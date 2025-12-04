import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Represents types of bill splitting logic.
 */
enum SplitType {
    EQUAL,
    EXACT,
    PERCENTAGE
}

/**
 * Basic User entity -> uniquely identified by id.
 */
class User {
    private final String id;
    private final String name;
    private final String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        return id.equals(((User) o).id);
    }
}

/**
 * Represents a group of users with associated expenses.
 */
class Group {
    private final String id;
    private String name;
    private final Set<User> members = new HashSet<>();
    private final List<Expense> expenses = new ArrayList<>();

    public Group(String id, String name, Collection<User> initialMembers) {
        this.id = id;
        this.name = name;
        if (initialMembers != null)
            members.addAll(initialMembers);
    }

    public String getId() {
        return id;
    }

    public Set<User> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    public void addMember(User user) {
        members.add(user);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public boolean containsUser(User user) {
        return members.contains(user);
    }
}

/**
 * Represents a split entry -> User + Amount owed.
 */
class Split {
    private final User user;
    private final BigDecimal amount;

    public Split(User user, BigDecimal amount) {
        this.user = user;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

/**
 * Expense transaction with payer, amount, strategy and finalized splits.
 */
class Expense {
    private final String id;
    private final String description;
    private final User paidBy;
    private final BigDecimal amount;
    private final Group group;
    private final SplitType splitType;
    private final List<Split> splits;

    public Expense(String id, String description, User paidBy, BigDecimal amount,
            Group group, SplitType splitType, List<Split> splits) {

        this.id = id;
        this.description = description;
        this.paidBy = paidBy;
        this.amount = amount;
        this.group = group;
        this.splitType = splitType;
        this.splits = splits;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<Split> getSplits() {
        return splits;
    }
}

/* ------------------- STRATEGY PATTERN ---------------------- */

/**
 * Strategy interface for splitting logic.
 */
interface SplitStrategy {
    List<Split> calculateSplits(SplitRequest request);
}

/**
 * Helper request object passed to strategy.
 */
class SplitRequest {
    private final BigDecimal totalAmount;
    private final List<User> participants;
    private final Map<User, BigDecimal> exactAmounts;
    private final Map<User, BigDecimal> percentages;

    private SplitRequest(Builder b) {
        totalAmount = b.totalAmount;
        participants = b.participants;
        exactAmounts = b.exactAmounts;
        percentages = b.percentages;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public Map<User, BigDecimal> getExactAmounts() {
        return exactAmounts;
    }

    public Map<User, BigDecimal> getPercentages() {
        return percentages;
    }

    public static class Builder {
        private BigDecimal totalAmount;
        private List<User> participants = new ArrayList<>();
        private Map<User, BigDecimal> exactAmounts = new HashMap<>();
        private Map<User, BigDecimal> percentages = new HashMap<>();

        public Builder withTotalAmount(BigDecimal amt) {
            totalAmount = amt;
            return this;
        }

        public Builder withParticipants(List<User> participants) {
            this.participants = participants;
            return this;
        }

        public Builder withExactAmounts(Map<User, BigDecimal> map) {
            exactAmounts = map;
            return this;
        }

        public Builder withPercentages(Map<User, BigDecimal> map) {
            percentages = map;
            return this;
        }

        public SplitRequest build() {
            return new SplitRequest(this);
        }
    }
}

/**
 * Equal split implementation.
 */
class EqualSplitStrategy implements SplitStrategy {
    public List<Split> calculateSplits(SplitRequest request) {
        BigDecimal total = request.getTotalAmount();
        int size = request.getParticipants().size();
        BigDecimal perHead = total.divide(new BigDecimal(size), 2, RoundingMode.DOWN);

        List<Split> result = new ArrayList<>();
        BigDecimal accumulated = BigDecimal.ZERO;

        for (int i = 0; i < size; i++) {
            BigDecimal share = perHead;
            if (i == size - 1)
                share = total.subtract(accumulated);
            result.add(new Split(request.getParticipants().get(i), share));
            accumulated = accumulated.add(share);
        }
        return result;
    }
}

/**
 * Exact amount split implementation.
 */
class ExactSplitStrategy implements SplitStrategy {
    public List<Split> calculateSplits(SplitRequest request) {
        BigDecimal sum = request.getExactAmounts().values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (!sum.equals(request.getTotalAmount()))
            throw new IllegalArgumentException("Sum of exact amounts mismatch");

        List<Split> result = new ArrayList<>();
        request.getExactAmounts().forEach((user, amt) -> result.add(new Split(user, amt)));
        return result;
    }
}

/**
 * Percentage based split implementation.
 */
class PercentageSplitStrategy implements SplitStrategy {
    public List<Split> calculateSplits(SplitRequest request) {
        BigDecimal totalPercent = request.getPercentages().values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (!totalPercent.equals(BigDecimal.valueOf(100)))
            throw new IllegalArgumentException("Percentage must sum to 100");

        BigDecimal totalAmount = request.getTotalAmount();
        List<Split> result = new ArrayList<>();

        for (Map.Entry<User, BigDecimal> entry : request.getPercentages().entrySet()) {
            BigDecimal share = totalAmount
                    .multiply(entry.getValue())
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
            result.add(new Split(entry.getKey(), share));
        }
        return result;
    }
}

/**
 * Factory returns strategy instance based on type.
 */
class SplitStrategyFactory {
    public static SplitStrategy getStrategy(SplitType type) {
        return switch (type) {
            case EQUAL -> new EqualSplitStrategy();
            case EXACT -> new ExactSplitStrategy();
            case PERCENTAGE -> new PercentageSplitStrategy();
        };
    }
}

/**
 * Ledger tracks debts: user A → owes → B.
 */
class Ledger {
    private final Map<User, Map<User, BigDecimal>> balances = new ConcurrentHashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addDebt(User debtor, User creditor, BigDecimal amount) {
        lock.writeLock().lock();
        try {
            if (debtor.equals(creditor))
                return;
            if (amount.compareTo(BigDecimal.ZERO) <= 0)
                return;

            BigDecimal current = balances
                    .computeIfAbsent(debtor, k -> new HashMap<>())
                    .getOrDefault(creditor, BigDecimal.ZERO);

            balances.get(debtor).put(creditor, current.add(amount));
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Map<User, BigDecimal> getUserBalances(User user) {
        lock.readLock().lock();
        try {
            return balances.getOrDefault(user, Collections.emptyMap());
        } finally {
            lock.readLock().unlock();
        }
    }

    public Map<User, Map<User, BigDecimal>> getAllBalances() {
        lock.readLock().lock();
        try {
            Map<User, Map<User, BigDecimal>> snapshot = new HashMap<>();
            for (Map.Entry<User, Map<User, BigDecimal>> entry : balances.entrySet()) {
                snapshot.put(entry.getKey(), new HashMap<>(entry.getValue()));
            }
            return snapshot;
        } finally {
            lock.readLock().unlock();
        }
    }

}

/**
 * Main service orchestrating user/group/expense + ledger update.
 */
class SplitwiseService {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();
    private final Ledger ledger = new Ledger();

    public User createUser(String id, String name, String email) {
        User user = new User(id, name, email);
        users.put(id, user);
        return user;
    }

    public Group createGroup(String id, String name, Collection<String> memberIds) {
        List<User> members = new ArrayList<>();
        memberIds.forEach(userId -> members.add(users.get(userId)));
        Group group = new Group(id, name, members);
        groups.put(id, group);
        return group;
    }

    public Expense addExpense(String expenseId, String description, String paidByUserId,
            BigDecimal amount, String groupId, SplitType splitType,
            List<String> participantUserIds, Map<String, BigDecimal> exactAmounts,
            Map<String, BigDecimal> percentages) {

        User payer = users.get(paidByUserId);
        Group group = (groupId != null) ? groups.get(groupId) : null;

        List<User> participants = participantUserIds.stream()
                .map(users::get).toList();

        SplitRequest.Builder builder = new SplitRequest.Builder()
                .withTotalAmount(amount)
                .withParticipants(participants);

        if (splitType == SplitType.EXACT) {
            Map<User, BigDecimal> map = new HashMap<>();
            exactAmounts.forEach((id, amt) -> map.put(users.get(id), amt));
            builder.withExactAmounts(map);
        }

        if (splitType == SplitType.PERCENTAGE) {
            Map<User, BigDecimal> map = new HashMap<>();
            percentages.forEach((id, pct) -> map.put(users.get(id), pct));
            builder.withPercentages(map);
        }

        SplitStrategy strategy = SplitStrategyFactory.getStrategy(splitType);
        List<Split> splits = strategy.calculateSplits(builder.build());

        Expense expense = new Expense(expenseId, description, payer, amount, group, splitType, splits);

        for (Split split : splits) {
            if (!split.getUser().equals(payer)) {
                ledger.addDebt(split.getUser(), payer, split.getAmount());
            }
        }

        if (group != null)
            group.addExpense(expense);

        return expense;
    }

    public Map<User, BigDecimal> getUserBalance(String userId) {
        return ledger.getUserBalances(users.get(userId));
    }

    public Map<User, Map<User, BigDecimal>> getAllBalances() {
        return ledger.getAllBalances();
    }
}

/**
 * Test Main to see output.
 */
public class SplitwiseSystem {
    public static void main(String[] args) {
        SplitwiseService service = new SplitwiseService();

        service.createUser("u1", "Alice", "alice@mail.com");
        service.createUser("u2", "Bob", "bob@mail.com");
        service.createUser("u3", "Charlie", "charlie@mail.com");

        service.createGroup("g1", "Trip", List.of("u1", "u2", "u3"));

        service.addExpense(
                "e1", "Hotel", "u1", new BigDecimal("300"),
                "g1", SplitType.EQUAL, List.of("u1", "u2", "u3"),
                null, null);

        System.out.println("Alice's Balance:");

        Map<User, BigDecimal> balanceMap = service.getUserBalance("u1");

        if (balanceMap.isEmpty()) {
            System.out.println(" Alice owes no one.");
        } else {
            balanceMap.forEach((user, amt) -> System.out.println(" Alice owes → " + user.getName() + " : " + amt));
        }

        // Print who owes Alice
        System.out.println("\nPeople who owe Alice:");
        service.getAllBalances().forEach((debtor, creditorMap) -> {
            creditorMap.forEach((creditor, amt) -> {
                if (creditor.getId().equals("u1")) {
                    System.out.println(" " + debtor.getName() + " → owes Alice : " + amt);
                }
            });
        });
    }
}

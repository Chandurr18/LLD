package strategy.locking;

import java.util.concurrent.*;

public class InMemoryLockProvider implements  LockProvider{
    private static class Expiry{
        final long deadLine;
        final String owner;
        Expiry(long deadLine, String owner){
            this.deadLine = deadLine;
            this.owner = owner;
        }
    }

    private final ConcurrentHashMap<String, Expiry> locks = new ConcurrentHashMap<>(); // key = "showId:SeatId"
    private final ScheduledExecutorService sweeper = Executors.newSingleThreadScheduledExecutor();

    public InMemoryLockProvider(){
        sweeper.scheduleAtFixedRate(this::sweep, 1, 1, TimeUnit.MINUTES);
    }

    private void sweep(){
        long now = System.currentTimeMillis();
        locks.entrySet().removeIf(e -> e.getValue().deadLine <= now);
    }


    @Override
    public boolean tryLock(String key, String userId, long ttlMs) {
        long now = System.currentTimeMillis();
        Expiry expiry = new Expiry(now + ttlMs, userId);
        return locks.compute(key, (k, v) -> (v == null || v.deadLine <= now) ? expiry : v) == expiry;
    }

    @Override
    public void unlock(String key) {
        locks.remove(key);
    }

    @Override
    public boolean isLockExpired(String key) {
        long now = System.currentTimeMillis();
        Expiry expiry = locks.get(key);
        if(expiry == null) return false;

        return expiry.deadLine < now;
    }

    @Override
    public boolean isLockedBy(String key, String userId) {
        Expiry expiry = locks.get(key);
        if(expiry == null) return false;

        return expiry.owner.equals(userId);
    }
}

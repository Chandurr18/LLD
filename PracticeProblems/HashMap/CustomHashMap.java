package PracticeProblems.HashMap;

class Node<K, V> {
    private final K key;
    private V value;

    public Node<K, V> prev, next;

    Node(K key, V value) {
        this.key = key;
        this.value = value;

        this.next = null;
        this.prev = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V newValue) {
        this.value = newValue;
    }
}


// hashMap = {{key1, value1}, {key2, value2}}
// hashSet = {key1, key2}

public class CustomHashMap<K, V> {
    private static final int INITIAL_SIZE = 4;
    private static final int MAX_CAPACITY = 1 << 30; // 2^30
    private static final float LOAD_FACTOR = 0.75f;
    private int countOfNodes = 0;

    private Node<K, V>[] map;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        map = new Node[INITIAL_SIZE];
        for (int i = 0; i < INITIAL_SIZE; i++) {
            map[i] = new Node<>(null, null); // Head
            map[i].next = new Node<>(null, null); // tail
            map[i].next.prev = map[i];
        }
    }

    public void put(K key, V value) {
        Node<K, V> node = findNode(key);

        if (node != null) {
            node.setValue(value);
            return;
        }

        int bucket = getBucket(key, map.length);

        Node<K, V> head = map[bucket];
        Node<K, V> nextNode = head.next;

        Node<K, V> newNode = new Node<>(key, value);

        head.next = newNode;
        newNode.prev = head;

        nextNode.prev = newNode;
        newNode.next = nextNode;

        countOfNodes++;

        if (countOfNodes >= (LOAD_FACTOR * map.length)) {
            rehash(map.length * 2);
        }
    }

    public V get(K key){
        Node<K, V> node = findNode(key);

        return node == null ? null : node.getValue();
    }

    public void remove(K key){
        Node<K, V> nodeToRemove = findNode(key);
        if(nodeToRemove == null) return;

        Node<K, V> prevNode = nodeToRemove.prev;
        Node<K, V> nextNode = nodeToRemove.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        countOfNodes--;

    }

    public int getSize(){ return countOfNodes; }

    @SuppressWarnings("unchecked")
    private void rehash(int newSize) {
        if (newSize > MAX_CAPACITY) {
            System.out.println("HashMap is exceeding max Capacity");
            return;
        }

        Node<K, V>[] newMap = new Node[newSize];

        for (int i = 0; i < newSize; i++) {
            newMap[i] = new Node<>(null, null); // Head
            newMap[i].next = new Node<>(null, null); // tail
            newMap[i].next.prev = newMap[i];
        }

        for (Node<K, V> cur : map) {
            while (cur != null) {
                if (cur.getKey() == null) { // ignore head and tail
                    cur = cur.next;
                    continue;
                }

                int newBucket = getBucket(cur.getKey(), newSize);

                Node<K, V> head = newMap[newBucket];
                Node<K, V> nextNode = head.next;
                Node<K, V> nextCur = cur.next;

                head.next = cur;
                cur.prev = head;

                nextNode.prev = cur;
                cur.next = nextNode;

                cur = nextCur;
            }
        }
        map = newMap;
    }

    private Node<K, V> findNode(K key) {
        int bucket = getBucket(key, map.length);

        Node<K, V> head = map[bucket];

        while (head != null) {
            if (head.getKey() != null && head.getKey().equals(key))
                return head;

            head = head.next;
        }
        return null;
    }

    private int getBucket(K key, int capacity){
        if(key == null) return 0;

        int bucket = Math.floorMod(key.hashCode(), capacity);
        return bucket;
    }
}
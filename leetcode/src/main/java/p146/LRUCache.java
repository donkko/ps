package p146;

import java.util.LinkedHashMap;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    final protected int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return this.size() > this.capacity;
    }
}

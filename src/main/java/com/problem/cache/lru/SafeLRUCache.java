package com.problem.cache.lru;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Non-Thread safe LRUCache. A LRUCache is a bounded cache. When cache exceeds
 * the capacity the oldest unused key is removed from the cache. A queue is used
 * to keep track of old keys where the oldest key is at the head of queue and
 * freshly used/fetched keys are at the beginning of queue.In case of cache hit
 * the key must be marked fresh and hence is removed from queue and moved to the
 * tail of queue. In case of cache miss, new element is moved to the head of
 * 
 * This implementation is not thread safe. <br/>
 * Pending <br/>
 * 1. Thread Safe Implementation <br/>
 * 2. Use of weak references for values as there is no limitation on its size.
 * Use WeakHashMap<br/>
 * 
 * @param <Key>
 * @param <Value>
 */
public class SafeLRUCache<Key, Value> {
    private final int maxCapacity;
    private int currentCapacity;
    private Map<Key, Value> lRUCache = null;
    private final PriorityQueue<Key> lRUList = new PriorityQueue<Key>();

    public SafeLRUCache(final int maxCapacity) {
        this.maxCapacity = maxCapacity;
        lRUCache = new HashMap<Key, Value>(this.maxCapacity);
    }

    /**
     * get operation is of order (1) because containsKey(), get() are of order
     * (1) on HashMap and offer() on PriorityQueue is of order (1).
     * 
     * @param key
     * @return
     */
    public Value get(final Key key) {
        Value value = null;
        if (lRUCache.containsKey(key)) {
            value = lRUCache.get(key);
            if (lRUList.remove(key)) {
                lRUList.offer(key);
            }
        }
        return value;
    }

    /**
     * put operation is of order (N) because remove(Key) on PriorityQueue is of
     * order (n).
     * 
     * @param key
     * @param value
     */
    public void put(final Key key, final Value value) {
        if (currentCapacity >= maxCapacity) {
            final Key oldestKey = lRUList.poll();
            lRUCache.remove(oldestKey);
        }
        lRUCache.put(key, value);
        lRUList.offer(key);
    }

}

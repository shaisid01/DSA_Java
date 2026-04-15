package dsa.LinkedListStackQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {

    @Test
    void testBasicPutGet() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        assertEquals(1, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    void testEvictionLRU() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        // access 1 → now 2 becomes LRU
        cache.get(1);

        cache.put(3, 3); // should evict key 2

        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2)); // evicted
        assertEquals(3, cache.get(3));
    }

    @Test
    void testUpdateExistingKey() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(1, 10); // update value

        assertEquals(10, cache.get(1));
    }

    @Test
    void testGetNonExistentKey() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);

        assertEquals(-1, cache.get(999));
    }

    @Test
    void testCapacityOne() {
        LRUCache cache = new LRUCache(1);

        cache.put(1, 1);
        cache.put(2, 2); // evicts 1

        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    void testLRUOrderStress() {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

        cache.get(1); // 2 becomes LRU

        cache.put(4, 4); // evicts 2

        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}
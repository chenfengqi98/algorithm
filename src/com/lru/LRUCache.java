package com.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description : lru
 * @Author : chen qi
 * @Date: 2021-09-08 16:53
 */
public class LRUCache {

    private int capacity;

    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return this.map.get(key);
    }

    public Integer put(int key, int val) {
        return map.put(key, val);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1, 1);
        System.out.println(lruCache.map);
        lruCache.put(2, 2);
        System.out.println(lruCache.map);
        lruCache.put(3, 3);
        System.out.println(lruCache.map);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.map);
        lruCache.put(4, 4);
        System.out.println(lruCache.map);
        lruCache.put(5, 6);
        System.out.println(lruCache.map);
        lruCache.put(7, 8);
        System.out.println(lruCache.map);
    }
}

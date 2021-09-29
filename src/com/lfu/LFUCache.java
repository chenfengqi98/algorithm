package com.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @Description : LFU 缓存
 * @Author : chen qi
 * @Date: 2021-09-29 09:39
 */
public class LFUCache {

    // key 到 val 的映射，我们后文称为 KV 表
    HashMap<Integer, Integer> keyToVal;
    // key 到 freq 的映射，我们后文称为 KF 表
    HashMap<Integer, Integer> keyToFreq;
    // freq 到 key 列表的映射，我们后文称为 FK 表
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val) {
        if (this.cap <= 0) return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            increaseFreq(key);
            return;
        }

        if (this.cap <= keyToVal.size()) {
            //
            removeMinFreqKey();
        }

        keyToVal.put(key, val);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    public void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        /* 更新 KF 表 */
        keyToFreq.put(key, freq + 1);
        /* 更新 FK 表 */
        // 将 key 从 freq 对应的列表中删除
        freqToKeys.get(freq).remove(key);
        // 将 key 加入 freq + 1 对应的列表中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        // 如果 freq 对应的列表空了，移除这个 freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // 如果这个 freq 恰好是 minFreq，更新 minFreq
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

    public void removeMinFreqKey() {
        // freq 最小的 key 列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // 其中最先被插入的那个 key 就是该被淘汰的 key
        int deletedKey = keyList.iterator().next();
        /* 更新 FK 表 */
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
            // 问：这里需要更新 minFreq 的值吗？
            // 不需要，调用 removeMinFreqKey 是put的时候调用的，put方法会设置 minFreq的值
        }
        /* 更新 KV 表 */
        keyToVal.remove(deletedKey);
        /* 更新 KF 表 */
        keyToFreq.remove(deletedKey);
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);

        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.put(3, 3);

        lfuCache.get(1);
        lfuCache.get(2);
        lfuCache.get(3);

        lfuCache.put(4, 4);

        System.out.println(lfuCache.keyToVal.toString());
    }
}

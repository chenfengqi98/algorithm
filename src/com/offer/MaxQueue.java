package com.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 *
 * @author chen
 * @date 2023/9/11
 */
public class MaxQueue {

    private final List<Integer> queue;
    private int maxValue;

    public MaxQueue() {
        queue = new ArrayList<>();
        maxValue = -1;
    }

    public int max_value() {
        return maxValue;
    }

    public void push_back(int value) {
        queue.add(value);
        maxValue = Math.max(value, maxValue);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer remove = queue.remove(0);
        if (queue.isEmpty()) {
            maxValue = -1;
        } else if (remove == maxValue) {
            List<Integer> copy = new ArrayList<>(queue);
            copy.sort(Integer::compareTo);
            maxValue = copy.get(copy.size() - 1);
        }
        return remove;
    }
}

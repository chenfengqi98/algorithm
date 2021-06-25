package com.leetcode;

import java.util.PriorityQueue;

/**
 * @Description : 1046.最后一块石头的重量
 * 1049.最后一块石头的重量II
 * @Author : chen qi
 * @Date: 2021-06-23 16:44
 */
public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            System.out.println(queue);
            int a = queue.poll();
            int b = queue.poll();
            if (a > b) {
                queue.offer(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public static int lastStoneWeightII(int[] stones) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}

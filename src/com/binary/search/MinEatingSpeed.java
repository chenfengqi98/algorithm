package com.binary.search;

/**
 * 875. 爱吃香蕉的珂珂
 * <p>
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 *
 * @author chen
 * @description
 * @date 2025/8/24
 */
public class MinEatingSpeed {
    public static int minEatingSpeed(int[] piles, int h) {
        int length = piles.length;
        int maxK = piles[length - 1];
        for (int pile : piles) {
            if (pile > maxK) {
                maxK = pile;
            }
        }
        if (length == h) {
            return maxK;
        }
        int minK = 1;
        while (minK <= maxK) {
            int midK = (minK + maxK) / 2;
            if (canEat(piles, h, midK)) {
                maxK = midK - 1;
            } else {
                minK = midK + 1;
            }
        }
        return minK;
    }

    public static boolean canEat(int[] piles, int h, int k) {
        // 最少一小时吃完
        int sum = piles.length;
        for (int pile : piles) {
            // 减去默认的一小时
            sum += (pile - 1) / k;
            if (sum > h) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] piles = {805306368, 805306368, 805306368};
        int h = 1000000000;
        int k = minEatingSpeed(piles, h);
        System.out.println(k);
    }
}

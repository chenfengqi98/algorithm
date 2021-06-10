package com.leetcode;

/**
 * @Description : 495.提莫攻击
 * @Author : chen qi
 * @Date: 2021-06-10 14:17
 */
public class FindPoisonedDuration {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length <= 1) {
            return timeSeries.length == 1 ? duration : 0;
        }
        int total = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] >= duration) {
                total += duration;
            } else {
                total = total + timeSeries[i + 1] - timeSeries[i];
            }
        }
        return total + duration;
    }

    public static void main(String[] args) {
        //1,3,5,7,9 3
        System.out.println(findPoisonedDuration(new int[]{1, 3, 5, 7, 9}, 3));
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));
    }
}

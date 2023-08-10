package com.leetcode;

/**
 * @author chen
 * @date 2023/8/10
 */
public class MinMaxGame2293 {

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 2, 4, 8, 2, 2};
        int i = minMaxGame(ints);
        System.out.println(i);
        System.out.println(minMaxGame2(ints));
    }

    public static int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] newNums = new int[nums.length / 2];
        for (int i = 0; i < nums.length / 2; i++) {
            if ((i & 1) == 1) {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newNums);
    }

    public static int minMaxGame2(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            for (int i = 0; i < nums.length / 2; i++) {
                if ((i & 1) == 1) {
                    nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                } else {
                    nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                }
            }
            n /= 2;
        }
        return nums[0];
    }

}

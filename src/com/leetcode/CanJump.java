package com.leetcode;

/**
 * @Description : 55.跳跃游戏
 * @Author : chen qi
 * @Date: 2020-09-25 16:34
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果当前位置 +i 可以到终点，终点 = i
            if (nums[i] + i >= end) {
                end = i;
            }
        }
        return end == 0;
    }

    public boolean canJump2(int[] nums) {
        if (nums == null) {
            return false;
        }
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > end) return false;
            end = Math.max(end, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums1 = {3, 2, 1, 0, 4};
        final CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(nums));
        System.out.println(canJump.canJump(nums1));
    }
}

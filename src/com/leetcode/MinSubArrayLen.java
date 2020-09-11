package com.leetcode;

/**
 * @Author chen qi
 * @Date 2020-08-04 16:41
 * @Description: 长度最小的子数组
 */
public class MinSubArrayLen {
    public static int minSubArrayLen(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int s = 11;
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(s, nums));
    }
}

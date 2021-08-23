package com.doublepointer;

import java.util.Arrays;

/**
 * @Description : 给定升序排列的数组，找到两个数等于目标数，返回索引
 * @Author : chen qi
 * @Date: 2021-08-23 17:32
 */
public class TwoSum {

    int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 7, 8};
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(ints, 10)));
    }
}

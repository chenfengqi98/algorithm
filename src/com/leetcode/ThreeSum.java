package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Description : 15.三数之和
 * @Author : chen qi
 * @Date: 2020-08-19 15:00
 */
public class ThreeSum {
    /**
     * 1.暴力
     * 2. 哈希
     * 3. 双指针
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len <= 2 || nums == null) {
            return result;
        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                List<Integer> curr = new ArrayList<>();
                int s = nums[k] + nums[i] + nums[j];
                if (s < 0) {
                    i = moveRight(nums, i + 1);
                }
                if (s > 0) {
                    j = moveLeft(nums, j - 1);
                }
                if (s == 0) {
                    curr.add(nums[k]);
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    result.add(curr);
                    i = moveRight(nums, i + 1);
                    j = moveLeft(nums, j - 1);
                }
            }
        }
        return result;
    }

    public static int moveLeft(int[] nums, int right) {
        while (right == nums.length - 1 || (right >= 0 && nums[right] == nums[right + 1])) {
            right--;
        }
        return right;
    }

    public static int moveRight(int[] nums, int left) {
        while (left == 0 || (left < nums.length && nums[left] == nums[left - 1])) {
            left++;
        }
        return left;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}

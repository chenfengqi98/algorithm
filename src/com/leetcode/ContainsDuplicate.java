package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chenqi
 * @date 2020-06-03 15:51
 * @Descripion 217.存在重复的元素
 * 219.存在重复的元素 II
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1 || nums == null) {
            return false;
        }
        Arrays.sort(nums);
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums, int k) {
        if (nums.length <= 1 || nums == null) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer val = map.get(nums[i]);
                if (i - val <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 5, 1, 2}));
        //System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 5, 1, 2}, 5));
        System.out.println(containsDuplicate(new int[]{1, 0, 1, 1}, 1));
    }
}

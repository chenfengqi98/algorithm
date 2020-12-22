package com.leetcode;

import java.util.HashMap;

/**
 * @Description : 219.存在重复元素II
 * @Author : chen qi
 * @Date: 2020-12-22 10:41
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer val = map.get(nums[i]);
                if (Math.abs(val - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        int[] nums = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate(nums, 1));
    }
}

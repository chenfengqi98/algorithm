package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description : 219.存在重复元素II
 * @Author : chen qi
 * @Date: 2020-12-22 10:41
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
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

    /**
     * 哈希set维护一个size = k 的窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])) {
                return true;
            }
            integers.add(nums[i]);
            if (integers.size() > k) {
                integers.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        int[] nums = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate(nums, 1));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate2(nums, 1));
    }
}

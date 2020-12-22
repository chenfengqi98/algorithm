package com.leetcode;

import java.util.TreeSet;

/**
 * @Description : 220.存在重复元素III
 * @Author : chen qi
 * @Date: 2020-12-22 10:55
 */
public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove((long)nums[i - k - 1]);
            }
            // Returns the least key greater than or equal to the given key,
            //     * or {@code null} if there is no such key.
            Long low = set.ceiling((long) nums[i] - t);
            //是否找到了符合条件的数
            if (low != null && low <= (long)nums[i] + t) {
                return true;
            }
            set.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate containsNearbyAlmostDuplicate = new ContainsNearbyAlmostDuplicate();
        int[] nums = {-2147483640, -2147483641};
        System.out.println(containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(nums, 1, 100));
    }
}

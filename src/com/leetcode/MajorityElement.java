package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 169.多数元素
 * @Author : chen qi
 * @Date: 2020-09-14 16:47
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {

        return method2(nums);
    }

    public int method1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        // 暴力
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > (nums.length / 2)) {
                return num;
            }
            map.put(num, count);
        }
        return 0;
    }

    public int method2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{8, 9, 8, 9, 8}));
    }
}

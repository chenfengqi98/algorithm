package com.leetcode;

import java.util.HashSet;

/**
 * @author chenqi
 * @date 2020-06-18 18:11
 * @Descripion 349.两个数字的交集
 */
public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i : nums1.length < nums2.length ? nums1 : nums2) {
            set.add(i);
        }
        for (int i : nums1.length > nums2.length ? nums1 : nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }
        int[] ints = new int[result.size()];
        int i = 0;
        for (Integer integer : result) {
            ints[i] = integer;
            i++;
        }
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(intersection(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
    }
}

package com.leetcode;

import java.util.*;

/**
 * @Description : 496.下一个更大元素
 * @Author : chen qi
 * @Date: 2021-06-18 14:00
 */
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == num1) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > num1) {
                            res[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return res;
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        //先对 nums2 中的每一个元素，求出它的右边第一个更大的元素；
        //将上一步的对应关系放入哈希表（HashMap）中
        int[] res = new int[nums1.length];

        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        int[] nums3 = {1, 5, 2};
        int[] nums4 = {2, 3, 5, 1, 0, 7, 3};
        System.out.println(Arrays.toString(nextGreaterElement2(nums3, nums4)));
    }
}

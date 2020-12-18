package com.sort;

import java.util.Arrays;

/**
 * @Description : 归并
 * @Author : chen qi
 * @Date: 2020-11-25 09:12
 */
public class MergeSort {

    private int[] mergeSort(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        left = mergeSort(left);
        right = mergeSort(right);

        int[] result = merge(left, right);

        return result;
    }

    private int[] merge(int[] left, int[] right) {
        if (left == null) {
            left = new int[0];
        }
        if (right == null) {
            right = new int[0];
        }
        int[] result = new int[left.length + right.length];
        int mi = 0, l = 0, r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                result[mi] = left[l];
                l++;
            } else {
                result[mi] = right[r];
                r++;
            }
            mi++;
        }
        if (l < left.length) {
            for (int i = l; i < left.length; i++) {
                result[mi++] = left[i];
            }
        }
        if (r < right.length) {
            for (int i = r; i < right.length; i++) {
                result[mi++] = right[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 34, 21, 45, 65, 2, 4, 36, 76, 23};
        MergeSort mergeSort = new MergeSort();
        int[] sorts = mergeSort.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sorts));
    }
}

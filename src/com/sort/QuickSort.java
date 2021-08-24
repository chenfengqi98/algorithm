package com.sort;

import java.util.Arrays;

/**
 * @Description : 快排
 * @Author : chen qi
 * @Date: 2021-08-24 15:26
 */
public class QuickSort {

    void sort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            sort(nums, left, partition - 1);
            sort(nums, partition, right);
        }
    }

    int partition(int[] nums, int left, int right) {
        if (nums == null || nums.length <= 0 || left < 0 || right >= nums.length) {
            return 0;
        }
        int pivot = nums[left + (right - left) / 2];
        while (left <= right) {
            while (nums[left] < pivot) {
                left++;
            }
            while (nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {23, 4, 1, 56, 76, 34, 12};
        quickSort.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }


}

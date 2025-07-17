package com.sort;

/**
 * @Author chen qi
 * @Date 2020-07-16 17:21
 * @Description: TODO
 */
public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        int length = nums.length;
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] nums) {
        int length = nums.length;
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = i; j < length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void bubbleSort3(int[] nums) {
        int length = nums.length;
        if (nums.length <= 1) {
            return;
        }
        int sortIndex = 0;
        while (sortIndex < length) {
            boolean swapped = false;
            for (int i = length - 1; i > sortIndex; i--) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            sortIndex++;
        }
    }


    public static void main(String[] args) {
        int[] nums = {3, 8, 2, 5, 1, 3};
        bubbleSort3(nums);
        for (int num : nums) {
            System.out.printf(num + "");
        }
    }
}

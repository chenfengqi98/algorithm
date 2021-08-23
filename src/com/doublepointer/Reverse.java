package com.doublepointer;

import java.util.Arrays;

/**
 * @Description : 反转数组
 * @Author : chen qi
 * @Date: 2021-08-23 18:06
 */
public class Reverse {

    void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int[] ints = {1, 3, 5, 7, 9};
        reverse.reverse(ints);
        System.out.println(Arrays.toString(ints));
    }

}

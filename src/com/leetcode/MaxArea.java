package com.leetcode;

/**
 * @Description : 最大面积
 * @Author : chen qi
 * @Date: 2020-08-13 18:48
 */
public class MaxArea {

    /**
     * 枚举
     *
     * @param nums
     * @return
     */
    public static int maxArea(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int area = (j - i) * Math.min(nums[i], nums[j]);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    /**
     * 边界收缩法，宽度小的往里面移动
     *
     * @param nums
     * @return
     */
    public static int maxArea2(int[] nums) {
        int max = 0;
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right) {
//            max = Math.max((right - left) * Math.min(nums[left], nums[right]), max);
//            if (nums[left] > nums[right]) {
//                --right;
//            } else {
//                left++;
//            }
//        }
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int minWidth = nums[i] > nums[j] ? nums[j--] : nums[i++];
            int area = minWidth * (j - i + 1);
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

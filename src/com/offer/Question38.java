package com.offer;

/**
 * @Author chen qi
 * @Date 2020-07-30 16:15
 * @Description: 数据在排序数组中出现的次数
 */
public class Question38 {
    public static int getNumberOfK(int[] nums, int k) {
        if (nums.length > 0) {
            int firstOfK = getFirstOfK(nums, k);
            int lastOfK = getLastOfK(nums, k);
            return lastOfK - firstOfK + 1;
        }
        return 0;
    }

    public static int getFirstOfK(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == k) {
                if (mid != 0 && nums[mid - 1] != k) {
                    return mid;
                } else {
                    result = mid;
                    right = mid;
                }
            } else if (nums[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return result;
    }

    public static int getLastOfK(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == k) {
                if (mid != 0 && nums[mid + 1] != k) {
                    return mid;
                } else {
                    result = mid;
                    left = mid + 1;
                }
            } else if (nums[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 5, 6};
        System.out.println(getFirstOfK(nums, 3));
        System.out.println(getLastOfK(nums, 3));
        System.out.println(getNumberOfK(nums, 2));
    }
}

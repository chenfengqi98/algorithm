package com.binary.search;

/**
 * @Description : 二分
 * @Author : chen qi
 * @Date: 2021-08-19 16:22
 */
public class BinarySearch {

    public int binarySearch(int[] nums, int target) {
        // 搜索区间 [left,right]
        int left = 0, right = nums.length - 1;

        // 终止条件是left == right + 1，[right+1,right]，此时区间为空
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 搜索 [mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索 [left,mid-1]
                right = mid - 1;
            }
        }
        return -1;
    }

    public int left_bound(int[] nums, int target) {
        // 搜索区间 [left,right)
        int left = 0, right = nums.length;
        // 终止条件 left == right ,[left,left)，此时区间为空
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 搜索 [left,mid)
                right = mid;
            } else if (nums[mid] < target) {
                // 搜索 [mid+1,right)
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索 [left,mid)
                right = mid;
            }
        }
        // target 比所有数都大
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public int left_bound1(int[] nums, int target) {
        // 搜索区间 [left,right]
        int left = 0, right = nums.length - 1;
        // 终止条件是left == right + 1，[right+1,right]，此时区间为空
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 搜索 [left,mid-1]
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 搜索 [mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索 [left,mid-1]
                right = mid - 1;
            }
        }
        if (left > nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int right_bound(int[] nums, int target) {
        // 搜索区间 [left,right)
        int left = 0, right = nums.length;
        // 终止条件 left == right ,[left,left)，此时区间为空
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 搜索 [mid+1,right)
                left = mid + 1;
            } else if (nums[mid] < target) {
                // 搜索 [mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索 [left,mid)
                right = mid;
            }
        }
        if (left == 0) return -1;
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    public int right_bound1(int[] nums, int target) {
        // 搜索区间 [left,right]
        int left = 0, right = nums.length - 1;
        // 终止条件是left == right + 1，[right+1,right]，此时区间为空
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 搜索 [mid+1,right]，锁定右侧边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                // 搜索 [mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索 [left,mid-1]
                right = mid - 1;
            }
        }
        if (right > nums.length || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(new int[]{1, 3, 5, 7, 9}, 3));
        System.out.println(binarySearch.left_bound(new int[]{1, 3, 3, 3, 3, 5, 7, 9}, 3));
        System.out.println(binarySearch.left_bound1(new int[]{1, 3, 3, 3, 3, 5, 7, 9}, 3));
        System.out.println(binarySearch.right_bound(new int[]{1, 3, 3, 3, 3, 5, 7, 9}, 3));
        System.out.println(binarySearch.right_bound1(new int[]{1, 3, 3, 3, 3, 5, 7, 9}, 3));
    }
}

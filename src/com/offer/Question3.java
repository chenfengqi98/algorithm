package com.offer;

/**
 * @Author chen qi
 * @Date 2020-07-30 10:04
 * @Description: 题目三
 * 二维数组中的查找
 * 在一个二维数组中，每一行走按照从左到右递增顺序排序，
 * 每一列都按照从上到下递增的顺序排序
 */
public class Question3 {
    public static boolean find(int[][] nums, int num) {
        if (nums != null && nums.length > 0 && nums[0].length > 0) {
            int row = 0;
            int col = nums[0].length - 1;
            while (row < nums.length && col >= 0) {
                if (nums[row][col] == num) {
                    return true;
                } else if (nums[row][col] > num) {
                    col--;
                } else {
                    row++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(nums, 3));
    }
}

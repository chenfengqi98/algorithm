package com.leetcode;

import java.util.Arrays;

public class RotateImage_48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 对角线镜像对称
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] ints : matrix) {
            revers(ints);
        }
    }

    void revers(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3, 4}, {5, 6, 7, 8}, {1, 3, 5, 7}, {2, 4, 6, 8}};
        System.out.println(Arrays.deepToString(ints));

        RotateImage_48 rotateImage_48 = new RotateImage_48();
        rotateImage_48.rotate(ints);
        System.out.println(Arrays.deepToString(ints));
    }
}

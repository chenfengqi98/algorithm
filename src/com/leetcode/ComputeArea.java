package com.leetcode;

/**
 * @Description : 223.矩形面积
 * @Author : chen qi
 * @Date: 2021-01-08 15:35
 */
public class ComputeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = Math.min(C, G) - Math.max(A, E);//重复的线段
        int y = Math.min(D, H) - Math.max(B, F);
        return (C - A) * (D - B) + (G - E) * (H - F) - x * y;
    }

    public static void main(String[] args) {
        ComputeArea computeArea = new ComputeArea();
        System.out.println(computeArea.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}

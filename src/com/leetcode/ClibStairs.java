package com.leetcode;

/**
 * @Description : 爬楼梯
 * @Author : chen qi
 * @Date: 2020-08-14 10:52
 */
public class ClibStairs {
    public static int clib(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        System.out.println(clib(4));
    }
}

package com.leetcode;

/**
 * @author chenqi
 * @date 2020-06-16 10:25
 * @Descripion 263. 丑数
 */
public class IsUgly {

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factor = {2, 3, 5};
        for (int i : factor) {
            while (n % i == 0) {
                n = n / i;
            }
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }
}

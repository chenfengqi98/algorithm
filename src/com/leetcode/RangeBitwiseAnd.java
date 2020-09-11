package com.leetcode;

/**
 * @Description : 201.数字范围按位与
 * @Author : chen qi
 * @Date: 2020-08-10 15:25
 */
public class RangeBitwiseAnd {
    public static int rangeBitwiseAnd(int m, int n) {
//        if (m == n) {
//            return m;
//        }
//        if (m == n - 1) {
//            return m & n;
//        }
//        int result = m & (m + 1);
//        for (int i = m + 2; i <= n; i++) {
//            result = result & i;
//        }
//        return result;
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        System.out.println(5 & 6 & 7);
        System.out.println(rangeBitwiseAnd(5, 7));
    }
}

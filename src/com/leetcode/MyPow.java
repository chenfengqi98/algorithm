package com.leetcode;

/**
 * @Description : 50.pow(x,n)
 * @Author : chen qi
 * @Date: 2020-09-07 15:56
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    public double fastPow(double x, int n) {
        // 1. terminator
        if (n == 0) {
            return 1.0;
        }
        // 2. split sub problems 子问题就是 x^n = x^(n/2) * x^(n/2)
        // 3. drill down
        double halfPow = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return halfPow * halfPow * x;
        }
        // 4. reverse state
    }

    public double bitPow(int x, int n) {
        double result = x;
        if (n < 0) {
            result = 1 / result;
            n = -n;
        }
        x = x << (n - 1);
        return x;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2.0, -2));
        System.out.println(myPow.bitPow(2, -2));
    }
}

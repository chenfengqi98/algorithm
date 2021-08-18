package com.dynamic.program;

import java.util.Arrays;

public class Fib {
    public int fib(int n) {
        // 暴力递归
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fib1(int n) {
        // 剪枝
        int[] ints = new int[n + 1];
        Arrays.fill(ints, 0);
        return fibHelper(ints, n);
    }

    public int fibHelper(int[] mem, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        mem[n] = fibHelper(mem, n - 1) + fibHelper(mem, n - 2);
        return mem[n];
    }

    public int fib2(int n) {
        // dp table
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib3(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = curr + pre;
            pre = curr;
            curr = sum;
        }
        return curr;
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(20));
        System.out.println(fib.fib1(20));
        System.out.println(fib.fib2(20));
        System.out.println(fib.fib3(20));
    }
}

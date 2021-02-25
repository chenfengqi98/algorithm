package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 279.完全平方数
 * @Author : chen qi
 * @Date: 2021-02-25 17:25
 */
public class NumSquares {
    private Map<Integer, Integer> map = new HashMap();

    /**
     * 回溯
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        return numSquaresHelper(n);
    }

    public int numSquaresHelper(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) return 0;
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, numSquaresHelper(n - i * i) + 1);
        }
        map.put(n, count);
        return count;
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        if (n == 0) return n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(13));
        System.out.println(numSquares.numSquares(12));
        System.out.println(numSquares.numSquares2(12));
    }
}

package com.dynamic.program;

import java.util.Arrays;

/**
 * @Description : 1143.最长公共子序列（Medium）
 * @Author : chen qi
 * @Date: 2021-10-13 16:03
 */
public class LongestCommonSubsequence {

    public static int[][] memo;

    public static int longestCommonSubsequence(String s1, String s2) {
        memo = new int[s1.length()][s2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s1, 0, s2, 0);
    }

    public static int dp(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.max(dp(s1, i, s2, j + 1), dp(s1, i + 1, s2, j));
        }
        return memo[i][j];
    }

    public static int longestCommonSubsequence2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}

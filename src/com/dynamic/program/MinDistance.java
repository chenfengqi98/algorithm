package com.dynamic.program;

/**
 * @Description : 583.两个字符串的删除操作
 * @Author : chen qi
 * @Date: 2021-10-13 17:09
 */
public class MinDistance {
    public static int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 最后两个字符串剩下最长公共子序列
        int lcs = LongestCommonSubsequence.longestCommonSubsequence(s1, s2);
        return m - lcs + n - lcs;
    }

    public static void main(String[] args) {
        int i = minDistance("sea", "eat");
        System.out.println(i);
    }
}

package com.leetcode;

import java.util.Arrays;

/**
 * @Description : 455.分发饼干
 * @Author : chen qi
 * @Date: 2020-09-25 16:11
 */
public class FindContentChildren {
    public Integer findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                result++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindContentChildren findContentChildren = new FindContentChildren();
        int[] g = {1, 3, 3}, s = {1, 2};
        System.out.println(findContentChildren.findContentChildren(g, s));
    }
}

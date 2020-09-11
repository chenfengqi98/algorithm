package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 22.括号生成
 * @Author : chen qi
 * @Date: 2020-09-05 15:05
 */
public class GenerateParenthesis {
    private static List<String> res = new ArrayList<>();

    private static List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return res;
    }

    private static void generate(int left, int right, int n, String curr) {
        // 1. terminate
        if (left == n && right == n) {
            res.add(curr);
            return;
        }
        // 2. process
//        String currLeft = curr + "(";
//        String currRight = curr + ")";
        // 3. drill down
        if (left < n) {
            // 左括号随便加，不能大于n
            generate(left + 1, right, n, curr + "(");
        }
        if (right < left) {
            // 右括号小于左括号时，才能添加
            generate(left, right + 1, n, curr + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}

package com.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description : 20.有效的括号
 * @Author : chen qi
 * @Date: 2021-09-18 15:48
 */
public class ValidParenthesis {

    /**
     * 20. 有效的括号
     *
     * @param s
     * @return
     */
    boolean isValid(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                queue.push(c);
            } else {
                if (!queue.isEmpty() && queue.peek().equals(leftOf(c))) {
                    queue.pop();
                } else {
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }

    char leftOf(char c) {
        if (c == ')') return '(';
        if (c == ']') return '[';
        return '{';
    }

    /**
     * 921. 是括号有效的最少添加
     *
     * @param s
     * @return
     */
    int minAddToMakeValid(String s) {
        int res = 0;
        // need 变量记录右括号的需求量
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                need++;
            }
            if (c == ')') {
                // 对右括号的需求 - 1
                need--;
                if (need == -1) {
                    // 右括号多，需要增加一个左括号
                    need = 0;
                    res++;
                }
            }
        }

        return res + need;
    }


    /**
     * 1541. 平衡括号字符串的最少插入次数
     * 一个左括号需要两个右括号
     *
     * @param s
     * @return
     */
    int minInsertions(String s) {
        int res = 0;
        int need = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 需要两个右括号
                need += 2;
                if (need % 2 == 1) {
                    // 如果对右括号的需求为奇数个，需要插入一个右括号，右括号的个数必须是两个
                    res++;
                    need--;
                }
            }

            if (c == ')') {
                need--;
                if (need == -1) {
                    // 插入一个左括号，需要两个右括号
                    res++;
                    need = 1;
                }
            }
        }

        return res + need;
    }

}

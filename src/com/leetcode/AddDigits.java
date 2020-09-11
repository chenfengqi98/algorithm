package com.leetcode;

/**
 * @author chenqi
 * @date 2020-06-05 16:34
 * @Descripion 258. 各位相加
 */
public class AddDigits {
    public static int addDigits(int num) {
        while (num >= 10) {
            num = num % 10 + num / 10;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}

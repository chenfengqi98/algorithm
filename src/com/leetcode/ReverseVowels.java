package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author chenqi
 * @date 2020-06-18 17:44
 * @Description 345.反转字符串中的元音字母
 */
public class ReverseVowels {

    private static HashSet<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u'));

    public static String reverseVowels(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            if (!vowelsSet.contains(chars[l])) {
                l++;
            } else if (!vowelsSet.contains(chars[r])) {
                r--;
            } else {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}

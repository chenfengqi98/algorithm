package com.leetcode;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author chenqi
 * @date 2020-06-16 11:15
 * @Description 290. 单词规律
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        return helper(pattern, str.split(" "));
    }

    public static boolean helper(String pattern, String[] str) {
        HashMap<Character, String> charMap = new HashMap<>();
        HashMap<String, Character> stringmap = new HashMap<>();
        if (pattern.length() != str.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = str[i];
            if (charMap.containsKey(c)) {
                if (!Objects.equals(charMap.get(c), s)) {
                    return false;
                }
            } else {
                charMap.put(c, s);
            }
        }
        for (int i = 0; i < str.length; i++) {
            char c = pattern.charAt(i);
            String s = str[i];
            if (stringmap.containsKey(s)) {
                if (!Objects.equals(stringmap.get(s), c)) {
                    return false;
                }
            } else {
                stringmap.put(s, c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(Character.isLetterOrDigit('.'));
    }
}

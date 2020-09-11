package com.leetcode;

import java.util.HashMap;

/**
 * @author chenqi
 * @date 2020-06-03 15:05
 * @Description 205.同构字符串
 */
public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char char1 = s.charAt(i);
//            char char2 = t.charAt(i);
//            if (map1.containsKey(char1)) {
//                Integer index = map1.get(char1);
//                if (t.charAt(index) != t.charAt(i)) {
//                    return false;
//                }
//            }
//            if (map2.containsKey(char2)) {
//                Integer index = map2.get(char2);
//                if (s.charAt(index) != s.charAt(i)) {
//                    return false;
//                }
//            }
//            map1.put(char1, i);
//            map2.put(char2, i);
//        }
//        return true;
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    public static boolean isIsomorphicHelper(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);
            if (map.containsKey(char1)) {
                if (map.get(char1) != char2) {
                    return false;
                }
            } else {
                map.put(char1, char2);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("pawer", "title"));
    }
}

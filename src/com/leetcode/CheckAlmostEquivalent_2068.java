package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckAlmostEquivalent_2068 {
    Map<Character, Integer> map = new HashMap<>();
    int[] chars = new int[26];

    boolean checkAlmostEquivalent(String word1, String word2) {
//        for (int i = 0; i < word1.length(); i++) {
//            char c = word1.charAt(i);
//            map.put(c, map.getOrDefault(c, 0) + 1);
//            char b = word2.charAt(i);
//            map.put(b, map.getOrDefault(b, 0) - 1);
//        }
//        map.values().stream().noneMatch(i -> Math.abs(i) > 3);
        for (int i = 0; i < word1.length(); i++) {
            int c = word1.charAt(i) - 'a';
            int b = word2.charAt(i) - 'a';
            chars[c] = chars[c] + 1;
            chars[b] = chars[b] - 1;
        }
        return Arrays.stream(chars).noneMatch(i -> Math.abs(i) > 3);
    }

    public static void main(String[] args) {
        CheckAlmostEquivalent_2068 check = new CheckAlmostEquivalent_2068();
        boolean b = check.checkAlmostEquivalent("aaaa", "bbbb");
        System.out.println(b);
    }
}

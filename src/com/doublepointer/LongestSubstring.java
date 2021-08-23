package com.doublepointer;

import java.util.HashMap;

/**
 * 最长无重复子串
 */
public class LongestSubstring {
    int longestSubstring(String source) {
        HashMap<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < source.length()) {
            char c = source.charAt(right);
            right++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);

            while (windows.get(c) > 1) {
                char l = source.charAt(left);
                left++;
                windows.put(l, windows.getOrDefault(l, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.longestSubstring("abcabcbb"));
    }
}

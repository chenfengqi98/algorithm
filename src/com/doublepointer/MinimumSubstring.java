package com.doublepointer;

import java.util.HashMap;

/**
 * @Description : 最小覆盖子串
 * @Author : chen qi
 * @Date: 2021-08-23 18:14
 */
public class MinimumSubstring {

    String minimumSubstring(String source, String target) {
        // 需要的字符数量
        HashMap<Character, Integer> needs = new HashMap<>();
        // 窗口中有的
        HashMap<Character, Integer> windows = new HashMap<>();
        for (char c : target.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        // 符合答案的数量
        int valid = 0;

        int left = 0, right = 0;
        while (right < source.length()) {
            char c = source.charAt(right);
            right++;
            // 加入窗口
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }
            while (valid == needs.keySet().size()) {
                // 记录答案
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char l = source.charAt(left);
                left++;
                if (needs.containsKey(l)) {
                    if (windows.get(l).equals(needs.get(l))) {
                        valid--;
                    }
                    windows.put(l, windows.getOrDefault(l, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : source.substring(start, right);
    }

    boolean isValidRes(HashMap<Character, Integer> needs, HashMap<Character, Integer> windows) {
        for (Character character : needs.keySet()) {
            if (needs.get(character) > windows.getOrDefault(character, 0)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        MinimumSubstring minimumSubstring = new MinimumSubstring();
        String s = minimumSubstring.minimumSubstring("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}

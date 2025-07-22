package com.slide.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 438.字母异位词，返回这些子串的起始索引
 */
public class FindAnagrams {
    List<Integer> findAnagrams(String source, String target) {
        // 需要的字符数量
        HashMap<Character, Integer> needs = new HashMap<>();
        // 窗口
        HashMap<Character, Integer> windows = new HashMap<>();
        for (char c : target.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < source.length()) {
            char c = source.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            while (right - left >= target.length()) {
                if (valid == needs.keySet().size()) {
                    res.add(left);
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
        return res;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams("cbaebabacd","abc"));
    }
}

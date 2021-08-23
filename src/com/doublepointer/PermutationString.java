package com.doublepointer;

import java.util.HashMap;

/**
 * @Description : 567. PermutationString，返回s2是否包含s1的排列
 * @Author : chen qi
 * @Date: 2021-08-23 18:50
 */
public class PermutationString {
    boolean permutationString(String target, String source) {
        // 需要的字符数量
        HashMap<Character, Integer> needs = new HashMap<>();
        // 窗口中有的
        HashMap<Character, Integer> windows = new HashMap<>();
        for (char c : target.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        // 符合答案的数量
        int valid = 0;

        int left = 0, right = 0;

        while (right < source.length()) {
            char c = source.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }

            while (right - left >= target.length()) {
                if (valid == needs.keySet().size()) {
                    return true;
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
        return false;
    }

    public static void main(String[] args) {
        PermutationString permutationString = new PermutationString();
        boolean b = permutationString.permutationString("ab", "asdasdadbsaba");
        System.out.println(b);
    }
}

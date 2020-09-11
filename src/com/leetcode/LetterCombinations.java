package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description : 17.电话号码的字母组合
 * @Author : chen qi
 * @Date: 2020-09-10 16:53
 */
public class LetterCombinations {
    public List<String> letterCombinations(String nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length() <= 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(map, "", nums, 0, res);
        return res;
    }

    public void helper(Map<Character, String> map, String curr, String nums, int index, List<String> res) {
        // 1. terminator
        if (index == nums.length()) {
            res.add(curr);
            return;
        }
        // 2. process
        String s = map.get(nums.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            helper(map, curr + s.charAt(i), nums, index + 1, res);
        }
        // 3. reverse state
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }
}

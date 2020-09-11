package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description : 211.添加与搜索单词
 * @Author : chen qi
 * @Date: 2020-08-10 16:04
 */
public class WordDictionary {
    /**
     * 单独hashSet会超时，所以根据单词长度建立
     */
    private HashMap<Integer, HashSet<String>> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if (map.containsKey(word.length())) {
            map.get(word.length()).add(word);
        } else {
            HashSet<String> set = new HashSet<>();
            set.add(word);
            map.put(word.length(), set);
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        HashSet<String> dic = map.getOrDefault(word.length(), new HashSet<>());
        if (!word.contains(".")) {
            return dic.contains(word);
        } else {
            for (String d : dic) {
                if (d.matches(word)) {
                    return true;
                }
//                if (d.length() == word.length()) {
//                    boolean find = true;
//                    for (int i = 0; i < d.length(); i++) {
//                        if (d.charAt(i) != word.charAt(i) && word.charAt(i) != '.') {
//                            find = false;
//                            break;
//                        }
//                    }
//                    if (find) {
//                        return true;
//                    }
//                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("pad");

        //System.out.println(wordDictionary.search("bad"));
//        System.out.println(wordDictionary.search(".ad"));
//        System.out.println(wordDictionary.search("b.."));

        System.out.println(wordDictionary.search("b.."));
    }
}

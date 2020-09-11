package com.leetcode;


/**
 * @Description : TODO
 * @Author : chen qi
 * @Date: 2020-08-10 17:35
 */
public class WordDictionaryWithTrie {
    class TrieNode {
        TrieNode[] children;
        boolean flag;

        public TrieNode() {
            children = new TrieNode[26];
            flag = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    TrieNode root;

    public WordDictionaryWithTrie() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            } else {
                curr = curr.children[c - 'a'];
            }
        }
        curr.flag = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelp(word, root);
    }

    private boolean searchHelp(String word, TrieNode root) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < array.length; i++) {
            // 对于 . , 递归的判断所有不为空的孩子
            if (array[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] != null) {
                        if (searchHelp(word.substring(i + 1), cur.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            }
            // 不含有当前节点
            if (cur.children[array[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[array[i] - 'a'];
        }
        // 当前节点是否为是某个单词的结束
        return cur.flag;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("pad");

        System.out.println(wordDictionary.search("b.."));
    }
}

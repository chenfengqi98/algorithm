package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author chen qi
 * @Date 2020-08-04 10:12
 * @Description: 208.前缀树
 */
public class Trie {
    Trie[] next = new Trie[26];
    boolean isEnd = false;

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new Trie();
            }
            curr = curr.next[c - 'a'];
        }
        curr.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                return false;
            } else {
                curr = curr.next[c - 'a'];
            }
        }
        return curr.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (char c : prefix.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                return false;
            } else {
                curr = curr.next[c - 'a'];
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

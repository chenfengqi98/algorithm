package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 1286.字母组合迭代器
 * 设计一个迭代器类，包括以下内容：
 * <p>
 * 一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
 * 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
 * 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
 * @Author : chen qi
 * @Date: 2021-06-16 15:35
 */
public class CombinationIterator {
    private char[] chars;
    private int combinationLength;
    private List<String> combinations = new ArrayList<>();
    private int cursor = 0;

    public CombinationIterator(String characters, int combinationLength) {
        this.chars = characters.toCharArray();
        this.combinationLength = combinationLength;
        combination("", 0);
    }

    public String next() {
        return combinations.get(cursor++);
    }

    public boolean hasNext() {
        return cursor != combinations.size();
    }

    public void combination(String curr, int start) {
        if (curr.length() == combinationLength) {
            combinations.add(curr);
            return;
        }
        for (int i = start; i < chars.length; i++) {
            combination(curr + chars[i], i + 1);
        }
    }

    public static void main(String[] args) {
        CombinationIterator combinationIterator = new CombinationIterator("abc", 2);
        System.out.println(combinationIterator.combinations);
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
    }
}

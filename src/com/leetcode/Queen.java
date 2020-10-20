package com.leetcode;

import java.util.*;

/**
 * @Description : 八皇后问题
 * @Author : chen qi
 * @Date: 2020-09-11 15:23
 */
public class Queen {
    // 之前的皇后站的位置
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> pie = new HashSet<>(); // 左对角线 已当前节点为坐标轴原点，x-y=0的线
    private Set<Integer> na = new HashSet<>(); // 右对角线  已当前节点为坐标轴原点，x+y=0的线

    public List<List<String>> queen(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1) {
            return new ArrayList<>();
        }
        helper(n, 0, new ArrayList<>(), res);
        return generateRes(res, n);
    }

    public void helper(int n, int row, List<Integer> curr, List<List<Integer>> res) {
        // 1.terminator
        if (row >= n) {
            res.add(curr);
            return;
        }
        // 2.process current level
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }
            cols.add(col);// 加入皇后影响范围
            pie.add(row + col);
            na.add(row - col);
            ArrayList<Integer> integers = new ArrayList<>(curr);
            integers.add(col);
            helper(n, row + 1, integers, res);

            // reverse state
            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
        }
    }

    /**
     * 打印棋盘
     *
     * @param res
     * @param n
     * @return
     */
    public List<List<String>> generateRes(List<List<Integer>> res, Integer n) {
        List<List<String>> strRes = new ArrayList<>();
        for (List<Integer> re : res) {
            List<String> currRes = new ArrayList<>();
            for (Integer integer : re) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[integer] = 'Q';
                String s = new String();
                for (char aChar : chars) {
                    s += aChar;
                }
                currRes.add(s);
            }
            strRes.add(currRes);
        }
        return strRes;
    }

    public static void main(String[] args) {
        Queen queue = new Queen();
        final List<List<String>> queen = queue.queen(4);
        queen.forEach(res -> {
            res.forEach(System.out::println);
            System.out.println("---------");
        });
    }
}

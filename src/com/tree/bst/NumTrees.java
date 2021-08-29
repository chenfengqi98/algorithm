package com.tree.bst;

import com.leetcode.data.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 96.不同的二叉搜索树
 * 95.不同的二叉搜索树II
 * 给你输入一个正整数n，请你计算，存储{1,2,3...,n}这些值共有有多少种不同的 BST 结构。
 */
public class NumTrees {

    int[][] memo;

    int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    /**
     * 统计 [low,high]闭区间组成BST个数
     *
     * @param low
     * @param high
     * @return
     */
    int count(int low, int high) {
        if (low > high) {
            // 当lo > hi闭区间[lo, hi]肯定是个空区间，也就对应着空节点 null，
            // 虽然是空节点，但是也是一种情况，所以要返回 1 而不能返回 0。
            return 1;
        }
        if (memo[low][high] != 0) {
            return memo[low][high];
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            // i 的值作为根节点 root
            int left = count(low, i - 1);
            int right = count(i + 1, high);
            res += left * right;
        }
        memo[low][high] = res;
        return res;
    }

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        int i = numTrees.numTrees(3);
        System.out.println(i);

        List<TreeNode> treeNodes = numTrees.generateTrees(3);
        System.out.println(treeNodes.size());
    }

    List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        // 构造闭区间 [1, n] 组成的 BST
        return build(1, n);
    }

    List<TreeNode> build(int low, int high) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (low > high) {
            res.add(null);
            return res;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTress = build(low, i - 1);
            List<TreeNode> rightTrees = build(i + 1, high);
            for (TreeNode left : leftTress) {
                for (TreeNode right : rightTrees) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}

package com.leetcode;

import com.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description : 222.完全二叉树的节点个数
 * @Author : chen qi
 * @Date: 2020-12-18 10:47
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        return countHelper(root);
    }

    public int countHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countHelper(root.left) + countHelper(root.right) + 1;
    }

    public int countHelper2(TreeNode root) {
        if (root == null) return 0;
        int left = countLevel(root.left);
        int right = countLevel(root.right);

        if (left == right) return countHelper2(root.right) + (1 << left);
        else {
            return countHelper2(root.left) + 1 << right;
        }
    }

    public int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            root = root.left;
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        CountNodes countNodes = new CountNodes();
        System.out.println(countNodes.countHelper(TreeNode.getTree()));
        System.out.println(countNodes.countHelper2(TreeNode.getTree()));
    }
}

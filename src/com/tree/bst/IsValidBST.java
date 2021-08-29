package com.tree.bst;

import com.leetcode.data.TreeNode;

/**
 * 98.验证二叉搜索树
 */
public class IsValidBST {
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        boolean validBST = isValidBST.isValidBST(TreeNode.getBSTree());
        System.out.println(validBST);
    }
}

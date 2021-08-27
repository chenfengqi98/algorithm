package com.tree.bst;

import com.leetcode.data.TreeNode;

/**
 * 538.二叉搜索树转换为累加树，使每个节点的新值等于原树中大于或等于 node.val的值之和
 */
public class ConvertBST {

    int sum = 0;

    TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        sum = sum + root.val;
        root.val = sum;
        traverse(root.left);
    }

    public static void main(String[] args) {
        TreeNode bsTree = TreeNode.getBSTree();
        TreeNode treeNode = new ConvertBST().convertBST(bsTree);
        System.out.println(treeNode.val);
    }
}

package com.tree.bst;

import com.leetcode.data.TreeNode;

/**
 * 230.二叉搜索树中第k小的元素
 */
public class KthSmallest {
    int rank = 0;
    int res = -1;

    int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode bsTree = TreeNode.getBSTree();
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(bsTree, 5));
    }
}

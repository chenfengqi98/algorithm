package com.tree;

import com.leetcode.TreeOrder;
import com.leetcode.data.TreeNode;

/**
 * 226.翻转二叉树
 */
public class InvertTree {

    TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        TreeOrder treeOrder = new TreeOrder();
        System.out.println(treeOrder.levelOrder(tree));
        tree = new InvertTree().invertTree(tree);
        System.out.println(treeOrder.levelOrder(tree));
    }
}

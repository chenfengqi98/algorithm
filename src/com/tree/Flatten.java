package com.tree;

import com.leetcode.TreeOrder;
import com.leetcode.data.TreeNode;

/**
 * 114.二叉树展开为列表
 */
public class Flatten {

    void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }


    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        TreeOrder treeOrder = new TreeOrder();
        System.out.println(treeOrder.levelOrder(tree));
        new Flatten().flatten(tree);
        System.out.println(treeOrder.levelOrder(tree));
    }
}

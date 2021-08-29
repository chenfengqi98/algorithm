package com.tree.bst;

import com.leetcode.data.TreeNode;

/**
 * 700.二叉树的搜索
 * 二叉树插入和删除
 */
public class IsInBST {
    boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        } else if (root.val > target) {
            return isInBST(root.left, target);
        } else {
            return isInBST(root.right, target);
        }
    }

    TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // case1 删除的节点没有子节点
            // case2 删除的节点只有一个子节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // case3 有两个子节点，需要找到左子树最大的节点或者右子树最小的节点
            // 找到右子树的最小节点
            TreeNode minNode = getMin(root.right);
            // 把 root 改成 minNode
            root.val = minNode.val;
            // 转而去删除 minNode
            root.right = deleteNode(root.right, minNode.val);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        IsInBST isInBST = new IsInBST();
        TreeNode bsTree = TreeNode.getBSTree();
        boolean inBST = isInBST.isInBST(bsTree, 3);
        System.out.println(inBST);

        TreeNode treeNode = isInBST.insertIntoBST(bsTree, 8);
        System.out.println(treeNode);

        TreeNode treeNode1 = isInBST.deleteNode(treeNode, 6);
        System.out.println(treeNode1);
    }
}

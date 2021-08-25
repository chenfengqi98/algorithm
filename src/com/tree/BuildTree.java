package com.tree;

import com.leetcode.TreeOrder;
import com.leetcode.data.TreeNode;

import java.util.List;

/**
 * 105.前序中序构造数
 */
public class BuildTree {
    public TreeNode buildTreePreInOrder(int[] preorder, int[] inorder) {
        return buildPreInOrder(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    TreeNode buildPreInOrder(int[] preorder, int preStart, int preEnd,
                             int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        // 前序遍历第一个值是root
        int rootVal = preorder[preStart];
        int index = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        // 左子树个数
        int leftTreeSize = index - inStart;

        // 递归构造左右子树
        // 左子树 前序遍历范围 prestart+根 到 prestart + 左子树节点个数，中序遍历范围 inStart，index-1
        root.left = buildPreInOrder(preorder, preStart + 1, preStart + leftTreeSize,
                inorder, inStart, index - 1);
        // 右子树 前序遍历范围 左子树个数+根+1 到 preEnd + 左子树节点个数，中序遍历范围 index+1，inEnd
        root.right = buildPreInOrder(preorder, preStart + leftTreeSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTreePreInOrder(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        List<List<Integer>> lists = new TreeOrder().levelOrder(treeNode);
        System.out.println(lists);

        TreeNode treeNode1 = buildTree.buildPostInOrder(new int[]{9, 15, 7, 20, 3}, new int[]{9, 3, 15, 20, 7});
        System.out.println(new TreeOrder().levelOrder(treeNode1));
    }


    TreeNode buildPostInOrder(int[] postorder, int[] inorder) {
        return buildPostInOrder(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    TreeNode buildPostInOrder(int[] postorder, int postStart, int postEnd,
                              int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd) {
            return null;
        }
        // 后序遍历 根是最后一个节点
        int rootVal = postorder[postEnd];
        int index = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }

        int leftTreeSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);

        // 左子树 后序遍历 postStart，postStart+左子树个数-1
        root.left = buildPostInOrder(postorder, postStart, postStart + leftTreeSize - 1,
                inorder, inStart, index - 1);
        // 右子树 后序遍历 postStart + leftTreeSize,postEnd-根
        root.right = buildPostInOrder(postorder, postStart + leftTreeSize, postEnd - 1,
                inorder, index + 1, inEnd);

        return root;
    }
}

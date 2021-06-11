package com.leetcode;

import com.leetcode.data.TreeNode;

/**
 * @Description : 1038.二叉搜索树转换为累加树
 * 二叉搜索树：
 * 若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 它的左、右子树也分别为二叉搜索树。
 * 二叉搜索树的中序遍历是一个单调递增的有序序列。
 * @Author : chen qi
 * @Date: 2021-06-11 16:29
 */
public class BstToGst {
    /**
     * 累加树：使每个节点的值修改成大于或等于当前节点的值之和
     * 反向中序遍历，记录值并更新当前节点
     *
     * @param root
     * @return
     */

    private static int sum = 0;

    public static TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode bsTree = TreeNode.getBSTree();
        inOrder(bsTree);
        System.out.println();
        bstToGst(bsTree);
        inOrder(bsTree);

    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
}

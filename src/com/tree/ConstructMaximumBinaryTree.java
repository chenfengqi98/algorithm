package com.tree;

import com.leetcode.TreeOrder;
import com.leetcode.data.TreeNode;

/**
 * 654.最大二叉树
 */
public class ConstructMaximumBinaryTree {
    TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = -1, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);

        root.left = buildTree(nums, left, index - 1);
        root.right = buildTree(nums, index + 1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode treeNode = new ConstructMaximumBinaryTree().constructMaximumBinaryTree(nums);
        System.out.println(new TreeOrder().levelOrder(treeNode));
    }
}

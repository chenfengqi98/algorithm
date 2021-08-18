package com.bfs;

import com.leetcode.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description : 111.二叉树最小深度
 * @Author : chen qi
 * @Date: 2021-08-18 17:06
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) { // 叶子节点
                    return depth;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                depth++;
            }
        }

        return depth;
    }

}

package com.leetcode;

import com.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqi
 * @date 2020-06-04 17:41
 * @Descripion 257.二叉树的所有路径
 */
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        binaryTreePathsHelper(root, "", result);
        return result;
    }

    public static void binaryTreePathsHelper(TreeNode root, String path, List<String> result) {
        if (root != null) {
            path += root.val;
            if (root.left == null && root.right == null) {
                result.add(path);
            } else {
                path += "->";
                binaryTreePathsHelper(root.left, path, result);
                binaryTreePathsHelper(root.right, path, result);
            }
        }
    }
}


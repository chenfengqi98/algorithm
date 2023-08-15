package com.leetcode;

import com.leetcode.data.TreeNode;
import com.tree.SerializeTree;

import java.util.Objects;

/**
 * 814 二叉树剪枝
 *
 * @author chen
 * @date 2023/8/14
 */
public class PruneTree814 {

    /**
     * 1. 后序遍历
     *
     * @param root
     * @return
     */
    public static TreeNode pruneTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeTree serializeTree = new SerializeTree();
        TreeNode treeNode = serializeTree.deserialize("1,#,0,0,#,#,1");

        TreeNode treeNode1 = pruneTree(treeNode);
        System.out.println(treeNode1);
    }

}

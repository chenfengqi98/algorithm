package com.tree;

import com.leetcode.data.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description : 652.寻找重复的子树
 * @Author : chen qi
 * @Date: 2021-08-27 14:22
 */
public class FindDuplicationSubTrees {
    List<TreeNode> findDuplicationSubTrees(TreeNode root) {
        LinkedList<TreeNode> res = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        traverse(root, res, map);
        return res;
    }

    String traverse(TreeNode root, LinkedList<TreeNode> res, HashMap<String, Integer> map) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left, res, map);
        String right = traverse(root.right, res, map);

        String subtree = left + "," + right + "," + root.val;

        Integer count = map.getOrDefault(subtree, 0);
        if (count == 1) {
            // 记录一次结果
            res.add(root);
        }
        map.put(subtree, count + 1);
        return subtree;
    }

    public static void main(String[] args) {
        /*
                    1
                   2  3
                  4   2 4
                     4
         */
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);

        root.left = node1;
        root.right = node3;

        node1.left = node2;

        root.right = node3;
        node3.left = node4;
        node3.right = node5;

        node4.left = node6;

        FindDuplicationSubTrees findDuplicationSubTrees = new FindDuplicationSubTrees();
        List<TreeNode> duplicationSubTrees = findDuplicationSubTrees.findDuplicationSubTrees(root);
        System.out.println(duplicationSubTrees);
    }
}

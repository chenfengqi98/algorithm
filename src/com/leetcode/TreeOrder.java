package com.leetcode;

import com.leetcode.data.TreeNode;

import java.util.*;

/**
 * @Description : 1. 二叉树的前，中，后，层次遍历
 * @Author : chen qi
 * @Date: 2020-09-07 16:22
 */
public class TreeOrder {
    public void preOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrder1(root.left);
        preOrder1(root.right);
    }

    public List<Integer> preOrder2(TreeNode root) {
        ArrayList<Integer> strings = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            strings.add(pop.val);
            if (pop.right != null) {
                treeNodes.push(pop.right);
            }
            if (pop.left != null) {
                treeNodes.push(pop.left);
            }
        }
        return strings;
    }

    public void inOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder1(root.left);
        System.out.print(root.val);
        inOrder1(root.right);
    }

    public List<Integer> inOrder2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !treeNodes.isEmpty()) {
            while (curr != null) {
                treeNodes.push(curr);
                curr = curr.left;
            }
            curr = treeNodes.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public void postOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder1(root.left);
        postOrder1(root.right);
        System.out.print(root.val);
    }

    public List<Integer> postOrder2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            res.add(pop.val);
            if (pop.left != null) {
                treeNodes.push(pop.left);
            }
            if (pop.right != null) {
                treeNodes.push(pop.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) return ans;
        TreeNode node = root;
        q.offer(node);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                subList.add(node.val);
            }
            ans.add(subList);
        }
        return ans;

    }

    public static void main(String[] args) {
        TreeOrder treeOrder = new TreeOrder();
        TreeNode treeNode = TreeNode.getTree();
        treeOrder.preOrder1(treeNode);
        System.out.println(treeOrder.preOrder2(treeNode));
        treeOrder.inOrder1(treeNode);
        System.out.println(treeOrder.inOrder2(treeNode));
        treeOrder.postOrder1(treeNode);
        System.out.println(treeOrder.postOrder2(treeNode));
        System.out.println(treeOrder.levelOrder(treeNode));
    }
}

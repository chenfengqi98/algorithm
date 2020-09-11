package com.leetcode;

import com.leetcode.data.NaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description : n叉树遍历
 * @Author : chen qi
 * @Date: 2020-09-07 19:05
 */
public class NaryTreeOrder {
    public void preOrder(NaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val);
        List<NaryTreeNode> children = treeNode.children;
        for (NaryTreeNode child : children) {
            preOrder(child);
        }
    }

    public List<Integer> preOrder1(NaryTreeNode treeNode) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<NaryTreeNode> naryTreeNodes = new LinkedList<>();
        if (treeNode == null) {
            return res;
        }
        naryTreeNodes.push(treeNode);
        while (!naryTreeNodes.isEmpty()) {
            NaryTreeNode pop = naryTreeNodes.pop();
            res.add(pop.val);
            if (!pop.children.isEmpty()) {
                //颠倒子节点
                Collections.reverse(pop.children);
                for (NaryTreeNode child : pop.children) {
                    naryTreeNodes.push(child);
                }
            }
        }
        return res;
    }

    public void postOrder(NaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        List<NaryTreeNode> children = treeNode.children;
        for (NaryTreeNode child : children) {
            postOrder(child);
        }
        System.out.print(treeNode.val);
    }

    public List<Integer> postOrder1(NaryTreeNode treeNode) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<NaryTreeNode> naryTreeNodes = new LinkedList<>();
        if (treeNode == null) {
            return res;
        }
        naryTreeNodes.push(treeNode);
        while (!naryTreeNodes.isEmpty()) {
            NaryTreeNode pop = naryTreeNodes.pop();
            res.add(pop.val);
            if (!pop.children.isEmpty()) {
                for (NaryTreeNode child : pop.children) {
                    naryTreeNodes.push(child);
                }
            }
        }
        Collections.reverse(res);
        return res;
    }

    public List<List<Integer>> levelOrder(NaryTreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<NaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NaryTreeNode poll = queue.poll();
                currLevel.add(poll.val);
                if (!poll.children.isEmpty()) {
                    queue.addAll(poll.children);
                }
            }
            res.add(currLevel);
        }
        return res;
    }

    public static void main(String[] args) {
        NaryTreeOrder naryTreeOrder = new NaryTreeOrder();
        naryTreeOrder.preOrder(NaryTreeNode.getNaryTreeNode());
        System.out.println(naryTreeOrder.preOrder1(NaryTreeNode.getNaryTreeNode()));
        System.out.println();
        naryTreeOrder.postOrder(NaryTreeNode.getNaryTreeNode());
        System.out.println(naryTreeOrder.postOrder1(NaryTreeNode.getNaryTreeNode()));
        System.out.println(naryTreeOrder.levelOrder(NaryTreeNode.getNaryTreeNode()));
    }
}

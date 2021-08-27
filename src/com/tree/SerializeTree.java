package com.tree;

import com.leetcode.data.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description : 序列化树
 * @Author : chen qi
 * @Date: 2021-08-27 13:48
 */
public class SerializeTree {

    String SEP = ",";
    String NULL = "#";


    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        // 前序遍历
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }


    TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return deserialize(nodes);
    }

    TreeNode deserialize(LinkedList<String> nodes) {
        // 前序
        if (nodes.isEmpty()) return null;

        String first = nodes.removeFirst();
        if (NULL.equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        SerializeTree serializeTree = new SerializeTree();
        String serialize = serializeTree.serialize(tree);
        System.out.println(serialize);
        TreeNode deserialize = serializeTree.deserialize(serialize);
        System.out.println(deserialize);

        String s = serializeTree.serializeByPostOrder(tree);
        System.out.println(s);
        TreeNode treeNode = serializeTree.deserializeByPostOrder(s);
        System.out.println(treeNode);
    }

    String serializeByPostOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeByPostOrder(root, sb);
        return sb.toString();
    }

    void serializeByPostOrder(TreeNode root, StringBuilder sb) {
        // 后序
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        serializeByPostOrder(root.left, sb);
        serializeByPostOrder(root.right, sb);
        sb.append(root.val).append(SEP);
    }


    TreeNode deserializeByPostOrder(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return deserializeByPostOrder(nodes);
    }

    TreeNode deserializeByPostOrder(LinkedList<String> nodes) {
        // 后序
        if (nodes.isEmpty()) return null;

        String first = nodes.removeLast();
        if (NULL.equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.right = deserializeByPostOrder(nodes);
        root.left = deserializeByPostOrder(nodes);

        return root;
    }
}

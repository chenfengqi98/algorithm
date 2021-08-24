package com.tree;

/**
 * 116.填充每个节点的下一个右侧节点
 */
public class ConnectTreeNode {
    TreeNodeWithNext connect(TreeNodeWithNext root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    void connectTwoNode(TreeNodeWithNext node1, TreeNodeWithNext node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** 前序遍历位置 ****/
        // 将传入的两个节点连接
        node1.next = node2;

        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);

        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }
}

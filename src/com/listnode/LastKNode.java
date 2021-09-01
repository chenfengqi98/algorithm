package com.listnode;

import com.doublepointer.ListNode;

/**
 * @Description : 19.删除链表倒数第N个节点
 * @Author : chen qi
 * @Date: 2021-09-01 17:10
 */
public class LastKNode {

    ListNode removeLastKNode(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 找到k+1
        ListNode node = getLastKNode(head, k + 1);
        node.next = node.next.next;
        return dummy.next;
    }

    ListNode getLastKNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LastKNode lastKNode = new LastKNode();
        ListNode node = lastKNode.removeLastKNode(node1, 2);
    }
}

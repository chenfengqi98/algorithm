package com.listnode;

import com.doublepointer.ListNode;

/**
 * @Description : 160.相交链表
 * @Author : chen qi
 * @Date: 2021-09-01 18:14
 */
public class GetIntersectionNode {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;curB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                curB = curB.next;
            }
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node3;
        node3.next = node5;
        node5.next = node6;

        node2.next = node4;
        node4.next = node5;

        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode intersectionNode = getIntersectionNode.getIntersectionNode(node1, node2);
        System.out.println(intersectionNode.val);


        intersectionNode = getIntersectionNode.getIntersectionNode2(node1, node2);
        System.out.println(intersectionNode.val);
    }
}

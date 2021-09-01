package com.listnode;

import com.doublepointer.ListNode;

import java.util.*;

/**
 * @Description : 21.合并两个有序列表，23.合并k个升序链表
 * @Author : chen qi
 * @Date: 2021-09-01 15:56
 */
public class MergeTwoLists {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode3;
        listNode3.next = listNode5;

        listNode2.next = listNode4;
        listNode4.next = listNode6;

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);

        ListNode node = mergeTwoLists.mergeKLists(new ListNode[]{null});
        System.out.println(node);
    }

    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        for (ListNode head : lists) {
            if (head != null) {
                listNodes.add(head);
            }
        }
        listNodes.sort(Comparator.comparingInt(a -> a.val));

        ListNode dummy = new ListNode(-1), p = dummy;

        while (!listNodes.isEmpty()) {
            ListNode node = listNodes.remove(0);
            p.next = node;
            if (node.next != null) {
                listNodes.add(node.next);
                // 可替换成优先级队列
//                new PriorityQueue<ListNode>(Comparator.comparingInt(a -> a.val));
                listNodes.sort(Comparator.comparingInt(a -> a.val));
            }
            p = p.next;
        }
        return dummy.next;
    }
}
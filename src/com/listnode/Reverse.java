package com.listnode;

import com.doublepointer.ListNode;

import java.util.List;

/**
 * @Description : 反转链表
 * @Author : chen qi
 * @Date: 2021-09-01 18:40
 */
public class Reverse {

    /**
     * 整个链表反转
     *
     * @param head
     * @return
     */
    ListNode reverse(ListNode head) {
        ListNode pre = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 反转 l1-l2之间的
     *
     * @param l1
     * @param l2
     * @return
     */
    ListNode reverse(ListNode l1, ListNode l2) {
        ListNode pre = null, curr = l1, next;
        while (curr != l2) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // 返回反转后的头结点
        return pre;
    }

    ListNode reversKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode l1 = head, l2 = head;
        for (int i = 0; i < k; i++) {
            // 不足k个
            if (l2 == null) return head;
            l2 = l2.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(l1, l2);
        // 递归反转后续链表并连接起来
        l1.next = reversKGroup(l2, k);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Reverse reverse = new Reverse();
//        ListNode reverse1 = reverse.reverse(node1);
//        System.out.println(reverse1);
//        ListNode reverse1 = reverse.reverse(node1, node3);
//        System.out.println(reverse1);
        ListNode node = reverse.reversKGroup(node1, 3);
        System.out.println(node);
    }

}

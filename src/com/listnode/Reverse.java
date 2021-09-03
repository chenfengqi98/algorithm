package com.listnode;

import com.doublepointer.ListNode;

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
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Reverse reverse = new Reverse();
        ListNode reverse1 = reverse.reverse(node1, null);
//        System.out.println(reverse1);
//        ListNode reverse1 = reverse.reverse(node1, node3);
//        System.out.println(reverse1);
//        ListNode node = reverse.reversKGroup(node1, 3);
//        System.out.println(node);
    }

    /**
     * 1->2->3->4->5->6->null
     *
     * reverseRecursion(head.next)
     * head = 1->2<-3-<4-<-5-<6 = last
     * 2->null
     *
     * head.next.next = head
     * head = 1<->2<-3<-4<-5-<6 = last
     *
     * head.next = null;
     * null<-1<-2<-3<-4<-5<-6 = last
     *
     * @param head
     * @return
     */
    ListNode reverseRecursion(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseRecursion(head.next);
        // head的下个节点的next指向head，head的next指向null，成为队尾
        head.next.next = head;
        head.next = null;
        return last;
    }

    private ListNode successor = null;

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}

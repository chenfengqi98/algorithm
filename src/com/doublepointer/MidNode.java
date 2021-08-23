package com.doublepointer;

/**
 * @Description : 链表中点，倒数第k个元素
 * @Author : chen qi
 * @Date: 2021-08-23 17:24
 */
public class MidNode {

    ListNode mid(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode lastK(ListNode head, int k) {
        ListNode fast, slow;
        fast = slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        {
            MidNode midNode = new MidNode();
            ListNode listNode1 = new ListNode(1);
            ListNode listNode2 = new ListNode(2);
            ListNode listNode3 = new ListNode(3);
            ListNode listNode4 = new ListNode(4);
            ListNode listNode5 = new ListNode(5);
            ListNode listNode6 = new ListNode(6);

            listNode1.next = listNode2;
            listNode2.next = listNode3;
            listNode3.next = listNode4;
            listNode4.next = listNode5;
            listNode5.next = listNode6;

            ListNode listNode = midNode.mid(listNode1);
            System.out.println(listNode.val);

            listNode = midNode.lastK(listNode1, 3);
            System.out.println(listNode.val);
        }
    }
}

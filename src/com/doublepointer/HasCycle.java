package com.doublepointer;

/**
 * @Description : 双指针经典
 * @Author : chen qi
 * @Date: 2021-08-23 17:11
 */
public class HasCycle {

    boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    ListNode detectedCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode3;

        boolean b = hasCycle.hasCycle(listNode1);
        System.out.println(b);
        ListNode listNode = hasCycle.detectedCycle(listNode1);
        System.out.println(listNode.val);
    }
}

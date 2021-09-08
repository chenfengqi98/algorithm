package com.lru;

/**
 * @Description : 双链表
 * @Author : chen qi
 * @Date: 2021-09-08 17:22
 */
public class DoubleList {
    Node head;
    Node tail;
    int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;

        size++;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }
}

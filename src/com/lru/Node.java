package com.lru;

/**
 * @Description : 节点
 * @Author : chen qi
 * @Date: 2021-09-08 17:21
 */
public class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

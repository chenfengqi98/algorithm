package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenqi
 * @date 2020-06-03 16:32
 * @Descripion 225.队列实现栈
 */
public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() > 1) {
            Integer remove = queue1.remove();
            queue2.add(remove);
            top = remove;
        }

        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return queue2.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}

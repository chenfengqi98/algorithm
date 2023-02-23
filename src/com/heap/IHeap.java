package com.heap;

/**
 * @author chen
 * @date 2022/9/8
 */
public interface IHeap<E> {
    boolean add(E e);

    boolean offer(E e);

    E poll();

    E peek();
}

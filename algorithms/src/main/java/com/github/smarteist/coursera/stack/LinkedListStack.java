package com.github.smarteist.coursera.stack;


// ~40N bytes per stack
public class LinkedListStack<T> {
    private Node first = null;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }


    public T peek() {
        return first.item;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }
}

package com.github.smarteist.coursera.stack;

public class ArrayStack<T> {

    private T[] s;
    private int N = 0;

    ArrayStack(int stackCapacity) {
        s = (T[]) new Object[stackCapacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(T item) {
        s[N++] = item;
    }

    public T pop() {
        return s[--N];
    }
}

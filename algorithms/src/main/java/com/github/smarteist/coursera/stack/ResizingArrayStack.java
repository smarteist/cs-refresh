package com.github.smarteist.coursera.stack;

public class ResizingArrayStack<T> {
    private T[] s;
    private int N = 0;

    ResizingArrayStack() {
        s = (T[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public void push(T item) {
        if (s.length == N) resize(2 * s.length);
        s[N++] = item;
    }

    public T pop() {
        T item = s[--N];
        s[N] = null;
        if (0 < N && N == s.length / 4) resize(s.length / 2);
        return item;
    }
}

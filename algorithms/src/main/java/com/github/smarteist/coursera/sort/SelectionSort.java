package com.github.smarteist.coursera.sort;

public class SelectionSort {

    // O(n^2)
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) { //N
            int min = i; //C
            for (int j = i + 1; j < N; j++) //N
                if (less(a[j], a[min]))
                    min = j; //C
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}

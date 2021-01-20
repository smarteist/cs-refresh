package com.github.smarteist.coursera.sort;

public class QuickSort {


    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) // find item on left to swap
                if (i == hi) break;
            while (less(a[lo], a[--j])) // find item on right to swap
                if (j == lo) break;
            if (i >= j) break; // check if pointers cross
            exch(a, i, j); // swap
        }
        exch(a, lo, j); // swap with partitioning item
        return j; // return index of item now known to be in place
    }
    private static boolean less(Comparable aux, Comparable aux1) {
        return aux.compareTo(aux1) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}

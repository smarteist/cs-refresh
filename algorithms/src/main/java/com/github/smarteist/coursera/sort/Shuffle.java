package com.github.smarteist.coursera.sort;

import java.util.Random;

public class Shuffle {

    public static void shuffle(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = new Random().nextInt(i + 1);
            exch(a, i, r);
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}

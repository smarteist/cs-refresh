package com.github.smarteist.coursera.sort;

import com.github.smarteist.MyBenchmark;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortTest {


    @Test
    public void shuffle() {
        Integer[] sorted = {1, 2, 3, 4, 5, 6};
        Shuffle.shuffle(sorted);

        boolean isSorted = true;
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != i + 1) {
                isSorted = false;
                break;
            }
        }
        assertFalse(isSorted);
    }

    @Test
    public void testSorts() {
        MyBenchmark benchmark = new MyBenchmark();
        // i cant wait more for bigger sizes :D
        int arraySizes = 100000;
        Integer[] array = getArray(arraySizes, true);

        Integer[] arr = Arrays.copyOf(array, array.length);
        benchmark.start();
        SelectionSort.sort(arr);
        System.out.printf("Selection  sort applied in %d nano seconds.\n", benchmark.stop());

        arr = Arrays.copyOf(array, array.length);
        benchmark.start();
        InsertionSort.sort(arr);
        System.out.printf("Insertion sort applied in %d nano seconds.\n", benchmark.stop());

        arr = Arrays.copyOf(array, array.length);
        benchmark.start();
        ShellSort.sort(arr);
        System.out.printf("Shell sort applied in %d nano seconds.\n", benchmark.stop());

        arr = Arrays.copyOf(array, array.length);
        benchmark.start();
        MergeSort.sort(arr);
        System.out.printf("Merge sort applied in %d nano seconds.\n", benchmark.stop());

        arr = Arrays.copyOf(array, array.length);
        benchmark.start();
        QuickSort.sort(arr);
        System.out.printf("Quick sort applied in %d nano seconds.\n", benchmark.stop());

        arr = Arrays.copyOf(array, array.length);
        benchmark.start();
        Arrays.sort(arr);
        System.out.printf("Java Arrays sort applied in %d nano seconds.\n", benchmark.stop());

    }


    // returns shuffled array with length of given argument
    private Integer[] getArray(int length, boolean shuffle) {
        Integer[] integers = new Integer[length];
        for (int i = 0; i < length; i++) {
            integers[i] = i;
        }
        if (shuffle)
            Shuffle.shuffle(integers);
        return integers;
    }
}
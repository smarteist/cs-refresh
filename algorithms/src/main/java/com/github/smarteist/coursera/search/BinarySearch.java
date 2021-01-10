package com.github.smarteist.coursera.search;

public class BinarySearch {


    public static int search(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (array[mid] == x) {
                return mid;
            } else if (array[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}

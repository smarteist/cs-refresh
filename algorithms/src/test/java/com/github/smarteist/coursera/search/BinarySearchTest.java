package com.github.smarteist.coursera.search;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BinarySearchTest {

    @Test
    public void search() {
        int[] toSearch = {1, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 22, 23, 33, 42, 45, 45, 56, 78};
        int search45 = BinarySearch.search(toSearch, 45);
        int search88 = BinarySearch.search(toSearch, 88);
        assertTrue(search45 > 0);
        assertTrue(search88 < 0);
    }
}
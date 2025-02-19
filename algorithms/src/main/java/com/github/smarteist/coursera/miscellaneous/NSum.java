package com.github.smarteist.coursera.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NSum {

    static List<List<Integer>> findNSum(int[] arr, int target, int n) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        findNSumHelper(arr, target, n, 0, new ArrayList<>(), result);
        return result;
    }

    static void findNSumHelper(int[] arr, int target, int n, int start, List<Integer> current, List<List<Integer>> result) {
        int len = arr.length;

        // Early termination if not enough elements or invalid n
        if (len - start < n || n < 2) {
            return;
        }

        // If n is 2, call the findTwoSum method
        if (n == 2) {
            findTwoSum(arr, target, start, current, result);
        } else {
            // Recursive case: fix one element and reduce the problem to (n-1)Sum
            for (int i = start; i <= len - n; i++) {
                // Skip duplicates
                if (i > start && arr[i] == arr[i - 1]) continue;

                // Early termination if remaining elements can't reach target
                int currentElement = arr[i];
                if (currentElement + (arr[len - 1] * (n - 1)) < target) continue;
                if (currentElement * n > target) break;

                current.add(currentElement);
                findNSumHelper(arr, target - currentElement, n - 1, i + 1, current, result);
                current.removeLast();
            }
        }
    }

    static void findTwoSum(int[] arr, int target, int start, List<Integer> current, List<List<Integer>> result) {
        int left = start, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                // Found a valid pair, add the combination
                List<Integer> combination = new ArrayList<>(current);
                combination.add(arr[left]);
                combination.add(arr[right]);
                result.add(combination);
                left++;
                right--;
                // Skip duplicates
                while (left < right && arr[left] == arr[left - 1]) left++;
                while (left < right && arr[right] == arr[right + 1]) right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        int n = 3;

        List<List<Integer>> results = findNSum(arr, target, n);
        if (results.isEmpty()) {
            System.out.println("No combinations found.");
        } else {
            for (List<Integer> combination : results) {
                System.out.println(combination);
            }
        }
    }
}

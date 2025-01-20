package com.github.smarteist.coursera.tree;

import java.util.ArrayList;
import java.util.List;

public class BST {
    private final List<Integer> tree;

    // Constructor
    public BST() {
        tree = new ArrayList<>();
    }

    // Public method to insert a value
    public void insert(int value) {
        if (tree.isEmpty()) {
            tree.add(value);
            return;
        }
        insertRec(0, value);
    }

    // Recursive method to insert a value at the correct position
    private void insertRec(int index, int value) {
        // If current index is beyond the current size, expand the list
        while (index >= tree.size()) {
            tree.add(null);
        }

        Integer currentValue = tree.get(index);

        if (currentValue == null) {
            tree.set(index, value);
            return;
        }

        if (value < currentValue) {
            insertRec(getLeftChildIndex(index), value); // Left child
        } else if (value > currentValue) {
            insertRec(getRightChildIndex(index), value); // Right child
        }
        // If value is equal, do not insert duplicates
    }

    // Helper methods to calculate child indices
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Pre-order Traversal: Root -> Left -> Right
    public List<Integer> preOrderTraversal() {
        List<Integer> traversal = new ArrayList<>();
        preOrderHelper(0, traversal);
        return traversal;
    }

    private void preOrderHelper(int index, List<Integer> traversal) {
        if (isValidIndex(index)) {
            Integer currentValue = tree.get(index);
            if (currentValue != null) {
                traversal.add(currentValue);
                preOrderHelper(getLeftChildIndex(index), traversal); // Left child
                preOrderHelper(getRightChildIndex(index), traversal); // Right child
            }
        }
    }

    // In-order Traversal: Left -> Root -> Right
    public List<Integer> inOrderTraversal() {
        List<Integer> traversal = new ArrayList<>();
        inOrderHelper(0, traversal);
        return traversal;
    }

    private void inOrderHelper(int index, List<Integer> traversal) {
        if (isValidIndex(index)) {
            Integer currentValue = tree.get(index);
            if (currentValue != null) {
                inOrderHelper(getLeftChildIndex(index), traversal); // Left child
                traversal.add(currentValue);
                inOrderHelper(getRightChildIndex(index), traversal); // Right child
            }
        }
    }

    // Post-order Traversal: Left -> Right -> Root
    public List<Integer> postOrderTraversal() {
        List<Integer> traversal = new ArrayList<>();
        postOrderHelper(0, traversal);
        return traversal;
    }

    private void postOrderHelper(int index, List<Integer> traversal) {
        if (isValidIndex(index)) {
            Integer currentValue = tree.get(index);
            if (currentValue != null) {
                postOrderHelper(getLeftChildIndex(index), traversal); // Left child
                postOrderHelper(getRightChildIndex(index), traversal); // Right child
                traversal.add(currentValue);
            }
        }
    }

    // Helper method to check if the index is valid
    private boolean isValidIndex(int index) {
        return index < tree.size();
    }

    // Main method to demonstrate BST operations
    public static void main(String[] args) {
        BST tree = new BST();

        // Insert elements into the BST
        int[] elements = {5, 3, 7, 2, 4, 6, 8};
        for (int elem : elements) {
            tree.insert(elem);
        }

        // DFS
        System.out.println("Pre-order Traversal: " + tree.preOrderTraversal());
        // DFS-TOUCH
        System.out.println("In-order Traversal: " + tree.inOrderTraversal());
        // DFS-BACKTRACK
        System.out.println("Post-order Traversal: " + tree.postOrderTraversal());
        // Expected Output:
        // Pre-order Traversal: [5, 3, 2, 4, 7, 6, 8]
        // In-order Traversal: [2, 3, 4, 5, 6, 7, 8]
        // Post-order Traversal: [2, 4, 3, 6, 8, 7, 5]
    }
}


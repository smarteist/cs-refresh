package com.github.smarteist.coursera.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Binary Search Tree (BST) implemented using an array-based structure.
 * Supports insertions and various depth-first traversal methods.
 */
public class BST {
    private final List<Integer> tree;

    /**
     * Constructs an empty BST.
     */
    public BST() {
        tree = new ArrayList<>();
    }

    /**
     * Inserts a value into the BST. Duplicates are ignored.
     * @param value The integer value to insert
     */
    public void insert(int value) {
        if (tree.isEmpty()) {
            tree.add(value);
            return;
        }
        insertRecursive(0, value);
    }

    /**
     * Returns pre-order traversal (Root -> Left -> Right)
     */
    public List<Integer> preOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(0, result);
        return result;
    }

    /**
     * Returns in-order traversal (Left -> Root -> Right)
     */
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(0, result);
        return result;
    }

    /**
     * Returns post-order traversal (Left -> Right -> Root)
     */
    public List<Integer> postOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(0, result);
        return result;
    }

    // Private helper methods ===============================================

    /**
     * Recursively finds the correct position to insert the value starting from given index.
     */
    private void insertRecursive(int currentIndex, int value) {
        ensureCapacity(currentIndex);

        Integer currentValue = tree.get(currentIndex);
        if (currentValue == null) {
            tree.set(currentIndex, value);
            return;
        }

        if (value < currentValue) {
            insertRecursive(getLeftChildIndex(currentIndex), value);
        } else if (value > currentValue) {
            insertRecursive(getRightChildIndex(currentIndex), value);
        }
    }

    /**
     * Ensures the tree array has sufficient capacity up to the specified index.
     */
    private void ensureCapacity(int index) {
        while (index >= tree.size()) {
            tree.add(null);
        }
    }

    private void preOrderTraversal(int index, List<Integer> result) {
        if (!isValidNode(index)) return;

        result.add(tree.get(index));
        preOrderTraversal(getLeftChildIndex(index), result);
        preOrderTraversal(getRightChildIndex(index), result);
    }

    private void inOrderTraversal(int index, List<Integer> result) {
        if (!isValidNode(index)) return;

        inOrderTraversal(getLeftChildIndex(index), result);
        result.add(tree.get(index));
        inOrderTraversal(getRightChildIndex(index), result);
    }

    private void postOrderTraversal(int index, List<Integer> result) {
        if (!isValidNode(index)) return;

        postOrderTraversal(getLeftChildIndex(index), result);
        postOrderTraversal(getRightChildIndex(index), result);
        result.add(tree.get(index));
    }

    /**
     * Checks if an index contains a valid tree node.
     */
    private boolean isValidNode(int index) {
        return index < tree.size() && tree.get(index) != null;
    }

    /**
     * Calculates left child index using array-based binary tree formula.
     */
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * Calculates right child index using array-based binary tree formula.
     */
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Demonstration ========================================================
    public static void main(String[] args) {
        BST bst = new BST();
        int[] elements = {5, 3, 7, 2, 4, 6, 8};

        for (int elem : elements) {
            bst.insert(elem);
        }

        // DFS
        System.out.println("Pre-order Traversal: " + bst.preOrderTraversal());
        // DFS-TOUCH
        System.out.println("In-order Traversal: " + bst.inOrderTraversal());
        // DFS-BACKTRACK
        System.out.println("Post-order Traversal: " + bst.postOrderTraversal());
        // Expected Output:
        // Pre-order Traversal: [5, 3, 2, 4, 7, 6, 8]
        // In-order Traversal: [2, 3, 4, 5, 6, 7, 8]
        // Post-order Traversal: [2, 4, 3, 6, 8, 7, 5]
    }
}
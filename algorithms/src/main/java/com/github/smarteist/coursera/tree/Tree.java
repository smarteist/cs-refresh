package com.github.smarteist.coursera.tree;

import java.util.ArrayList;
import java.util.List;


// Tree class managing the overall tree structure and traversals
public class Tree {
    private final TreeNode root;
    private int size;

    // Constructor
    public Tree(int rootValue) {
        this.root = new TreeNode(rootValue);
        this.size = 1;
    }

    // Getter for the root node
    public TreeNode getRoot() {
        return this.root;
    }

    // Method to add a node to the tree based on parent and child values
    public void addEdge(int parentValue, int childValue) {
        // Find the parent node
        TreeNode parentNode = findNode(this.root, parentValue);
        if (parentNode != null) {
            TreeNode childNode = new TreeNode(childValue);
            parentNode.addChild(childNode);
            this.size++;
        } else {
            System.out.println("Parent node with value " + parentValue + " not found.");
        }
    }

    // Helper method to find a node with a given value (DFS)
    private TreeNode findNode(TreeNode current, int value) {
        if (current.value == value) {
            return current;
        }
        for (TreeNode child : current.children) {
            TreeNode result = findNode(child, value);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    // Pre-order Traversal: Root -> Children
    public List<Integer> preOrderTraversal() {
        List<Integer> traversal = new ArrayList<>();
        preOrderHelper(this.root, traversal);
        return traversal;
    }

    private void preOrderHelper(TreeNode node, List<Integer> traversal) {
        if (node == null) return;
        traversal.add(node.value);
        for (TreeNode child : node.children) {
            preOrderHelper(child, traversal);
        }
    }

    // In-order Traversal: Traverse first child, visit node, traverse remaining children
    public List<Integer> inOrderTraversal() {
        List<Integer> traversal = new ArrayList<>();
        inOrderHelper(this.root, traversal);
        return traversal;
    }

    private void inOrderHelper(TreeNode node, List<Integer> traversal) {
        if (node == null) return;
        int n = node.children.size();
        if (n > 0) {
            // Traverse the first child
            inOrderHelper(node.children.get(0), traversal);
        }
        // Visit the current node
        traversal.add(node.value);
        // Traverse the remaining children
        for (int i = 1; i < n; i++) {
            inOrderHelper(node.children.get(i), traversal);
        }
    }

    // Post-order Traversal: Children -> Root
    public List<Integer> postOrderTraversal() {
        List<Integer> traversal = new ArrayList<>();
        postOrderHelper(this.root, traversal);
        return traversal;
    }

    private void postOrderHelper(TreeNode node, List<Integer> traversal) {
        if (node == null) return;
        for (TreeNode child : node.children) {
            postOrderHelper(child, traversal);
        }
        traversal.add(node.value);
    }

    public int getSize() {
        return size;
    }

    // Main method to demonstrate tree creation and traversals
    public static void main(String[] args) {
        // Initialize the tree with root node value 1
        Tree tree = new Tree(1);

        // Define the edges as provided
        int[][] edges = {
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 5},
                {3, 6},
                {3, 7},
                {3, 8},
                {5, 9},
                {8, 10},
                {8, 11},
                {9, 12},
                {9, 13}
        };

        // Add edges to the tree
        for (int[] edge : edges) {
            tree.addEdge(edge[0], edge[1]);
        }


        // DFS
        System.out.println("Pre-order Traversal: " + tree.preOrderTraversal());
        // DFS-TOUCH
        System.out.println("In-order Traversal: " + tree.inOrderTraversal());
        // DFS-BACKTRACK
        System.out.println("Post-order Traversal: " + tree.postOrderTraversal());
        // Pre-order Traversal: [1, 2, 3, 6, 7, 8, 10, 11, 4, 5, 9, 12, 13]
        // In-order Traversal: [2, 1, 6, 3, 7, 10, 8, 11, 4, 12, 9, 13, 5]
        // Post-order Traversal: [2, 6, 7, 10, 11, 8, 3, 4, 12, 13, 9, 5, 1]
    }
}

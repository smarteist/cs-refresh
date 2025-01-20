package com.github.smarteist.coursera.tree;


import java.util.ArrayList;
import java.util.List;

// TreeNode class representing each node in the tree
class TreeNode {
    int value;
    List<TreeNode> children;

    // Constructor
    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    // Add a child to the current node
    public void addChild(TreeNode child) {
        this.children.add(child);
    }
}

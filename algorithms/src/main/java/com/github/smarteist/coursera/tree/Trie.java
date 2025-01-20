package com.github.smarteist.coursera.tree;

import java.util.HashMap;
import java.util.Map;

// Define the TrieNode class
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie in a non-circular manner.
     * This inserts all possible substrings of the word.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) return;

        int wordLength = word.length();

        // Insert all possible substrings in a non-circular manner
        for (int i = 0; i < wordLength; i++) {
            for (int j = i + 1; j <= wordLength; j++) {
                String substring = word.substring(i, j);
                insertSubstring(substring);
            }
        }
    }

    /**
     * Inserts a word into the trie, considering all circular rotations.
     */
    public void insertCircular(String word) {
        if (word == null || word.isEmpty()) return;

        int wordLength = word.length();
        String doubleWord = word + word; // Concatenate the word to itself to handle circularity

        // Iterate over each possible starting position for rotations
        for (int i = 0; i < wordLength; i++) {
            // Extract the rotation starting at position i
            String rotation = doubleWord.substring(i, i + wordLength);
            // Insert all possible substrings of this rotation into the Trie
            for (int j = 1; j <= wordLength; j++) { // Substring lengths from 1 to wordLength
                String substring = rotation.substring(0, j);
                insertSubstring(substring);
            }
        }
    }

    /**
     * Helper method to insert a single substring into the Trie
     */
    private void insertSubstring(String substring) {
        TrieNode node = root;
        for (char ch : substring.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the trie (exact match).
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;

        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return false;
        }
        return node.isEndOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) return false;

        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("GAS");
        trie.insert("GARLIC");
        trie.insert("GLOBE");
        trie.insert("GLOW");
        trie.insert("JAZZ");
        trie.insert("JANE");
        trie.insert("JOKE");
        trie.insert("PASS");
        trie.insert("PASSIVE");
        trie.insert("PALE");
        trie.insert("PORT");
        trie.insert("POKE");


        System.out.println(trie.search("OK"));
        System.out.println(trie.search("OKAY"));
        System.out.println(trie.search("ASSIVE"));
        System.out.println(trie.search("POR"));
        System.out.println(trie.search("LEP"));
        System.out.println(trie.search("AZZ"));
        System.out.println(trie.search("GAS"));
        System.out.println(trie.search("ASG"));
        System.out.println(trie.search("SAG"));
        System.out.println(trie.startsWith("GA"));
        System.out.println(trie.startsWith("GL"));
        System.out.println(trie.startsWith("JO"));
        System.out.println(trie.startsWith("PA"));
        System.out.println(trie.startsWith("ZZAJ"));
        System.out.println(trie.startsWith("LOW"));


/*

        Trie circularTrie = new Trie();
        circularTrie.insertCircular("GAS");
        circularTrie.insertCircular("GARLIC");
        circularTrie.insertCircular("GLOBE");
        circularTrie.insertCircular("GLOW");
        circularTrie.insertCircular("JAZZ");
        circularTrie.insertCircular("JANE");
        circularTrie.insertCircular("JOKE");
        circularTrie.insertCircular("PASS");
        circularTrie.insertCircular("PASSIVE");
        circularTrie.insertCircular("PALE");
        circularTrie.insertCircular("PORT");
        circularTrie.insertCircular("POKE");

        System.out.println(circularTrie.search("OK"));        // true
        System.out.println(circularTrie.search("OKAY"));      // false
        System.out.println(circularTrie.search("ASSIVE"));   // true
        System.out.println(circularTrie.search("POR"));       // true
        System.out.println(circularTrie.search("LEP"));       // true
        System.out.println(circularTrie.search("AZZ"));       // true
        System.out.println(circularTrie.search("GAS"));       // true
        System.out.println(circularTrie.search("ASG"));       // false
        System.out.println(circularTrie.search("SAG"));       // true (if circular)
        System.out.println(circularTrie.startsWith("GA"));    // true
        System.out.println(circularTrie.startsWith("GL"));    // true
        System.out.println(circularTrie.startsWith("JO"));    // true
        System.out.println(circularTrie.startsWith("PA"));    // true
        System.out.println(circularTrie.startsWith("ZZAJ"));    // false
        System.out.println(circularTrie.startsWith("LOW"));    // true*/

    }
}

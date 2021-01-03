package com.github.smarteist.coursera.dynamicconnetivity;

public abstract class UnionFind {

    protected final int[] objects;

    UnionFind(int[] input) {
        this.objects = input;
    }

    public abstract boolean connected(int a, int b);

    public abstract void union(int a, int b);

}

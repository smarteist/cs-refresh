package com.github.smarteist.coursera.dynamicconnetivity;

// find root operation is to slow with N access to array
public class LazyApproach extends UnionFind {

    protected int[] ids;

    LazyApproach(int[] input) {
        super(input);
        ids = new int[input.length];
        System.arraycopy(input, 0, ids, 0, input.length);
    }

    protected int root(int i) {
        while (i != ids[i]) {
            i = ids[i];
        }
        return i;
    }

    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    public void union(int a, int b) {
        int i = root(a);
        int j = root(b);
        ids[i] = j;
    }

    public int[] getIds() {
        return ids;
    }

}

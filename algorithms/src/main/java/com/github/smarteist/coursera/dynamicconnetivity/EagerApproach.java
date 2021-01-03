package com.github.smarteist.coursera.dynamicconnetivity;

// Union method has N^2 time complexity!!
class EagerApproach extends UnionFind {


    protected int[] ids;

    EagerApproach(int[] input) {
        super(input);
        ids = new int[input.length];
        System.arraycopy(input, 0, ids, 0, input.length);
    }


    public boolean connected(int a, int b) {
        return ids[a] == ids[b];
    }

    public void union(int a, int b) {
        int aid = ids[a];
        int bid = ids[b];
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == aid) {
                ids[i] = bid;
            }
        }
    }

    public int[] getIds() {
        return ids;
    }
}
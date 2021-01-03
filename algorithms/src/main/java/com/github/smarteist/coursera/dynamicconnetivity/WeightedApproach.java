package com.github.smarteist.coursera.dynamicconnetivity;

// Adds weighted children in tree
public class WeightedApproach extends LazyApproach {

    protected int[] size;

    WeightedApproach(int[] input) {
        super(input);
        size = new int[input.length];
    }

    public void union(int a, int b) {
        int i = root(a);
        int j = root(b);
        if (i == j) {
            return;
        }
        if (size[i] < size[j]) {
            ids[i] = j;
            size[j] += size[i];
        } else {
            ids[j] = i;
            size[i] += size[j];
        }
    }

    public int[] getWeights() {
        return size;
    }

}

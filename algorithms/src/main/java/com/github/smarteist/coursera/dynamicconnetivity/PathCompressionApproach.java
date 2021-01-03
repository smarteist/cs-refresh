package com.github.smarteist.coursera.dynamicconnetivity;

// lg*N time complexity
public class PathCompressionApproach extends WeightedApproach {

    PathCompressionApproach(int[] input) {
        super(input);
    }

    protected int root(int i) {
        while (i != ids[i]) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }
}

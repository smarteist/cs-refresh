package com.github.smarteist.coursera.dynamicconnetivity;

import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DynamicConnectivityTests {

    static List<UnionFind> unionFinds = new ArrayList<>();

    @BeforeClass
    public static void beforeClass() {
        int[] items = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        unionFinds.add(new EagerApproach(items));
        unionFinds.add(new LazyApproach(items));
        unionFinds.add(new WeightedApproach(items));
        unionFinds.add(new PathCompressionApproach(items));
    }

    @Test
    public void connected() {
        for (UnionFind unionFind : unionFinds) {
            unionFind.union(4, 5);
            assertTrue(unionFind.connected(4, 5));
        }
    }

    @Test
    public void union() {
        for (UnionFind unionFind : unionFinds) {
            long time = System.nanoTime();
            assertFalse(unionFind.connected(1, 2));
            unionFind.union(1, 2);
            assertTrue(unionFind.connected(1, 2));
            // Here we see the difference in action!
            System.out.printf("Test done in (%d Nano Seconds) for %s\n", System.nanoTime() - time, unionFind.getClass());
        }
    }
}
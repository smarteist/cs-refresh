package com.github.smarteist.coursera.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstrasAlgorithmTest {

    @Test
    public void parse() {
        Double parse = ShuntingYardAlgorithm.calculate("((4 - (2 * (5 + 4)) / 6) + 7)");
        int i = ((4 - ((2 * (5 + 4)) / 6)) + 7);
        Double parse2 = ShuntingYardAlgorithm.calculate("(1 + ((2 + 3) * (4 * 5)))");
        int i2 = (1 + ((2 + 3) * (4 * 5)));
        assertEquals(0, parse - i, 0);
        assertEquals(0, parse2 - i2, 0);
    }
}
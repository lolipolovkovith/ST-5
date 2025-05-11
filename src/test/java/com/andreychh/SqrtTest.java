package com.andreychh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {
    private final double DELTA = 0.00000001;
    private final double ARG = 2.0;
    private final Sqrt sqrt = new Sqrt(ARG, DELTA);

    @Test
    void averageTest() {
        double x = 2.0;
        double y = 4.0;
        double expected = 3.0;
        assertEquals(expected, sqrt.average(x, y), DELTA);
    }

    @Test
    void goodTest_goodGuess() {
        double guess = 1.41421356;
        assertTrue(sqrt.good(guess, ARG));
    }

    @Test
    void goodTest_badGuess() {
        double guess = 1.0;
        assertFalse(sqrt.good(guess, ARG));
    }

    @Test
    void improveTest() {
        double guess = 1.0;
        double expected = 1.5;
        assertEquals(expected, sqrt.improve(guess, ARG), DELTA);
    }

    @Test
    void iterTest_goodGuess() {
        double guess = 1.41421356;
        assertEquals(guess, sqrt.iter(guess, ARG), DELTA);
    }

    @Test
    void iterTest_badGuess() {
        double guess = 1.0;
        assertEquals(Math.sqrt(ARG), sqrt.iter(guess, ARG), DELTA);
    }

    @Test
    void calcTest() {
        assertEquals(Math.sqrt(ARG), sqrt.calc(), DELTA);
    }

    @Test
    void sqrtWithDifferentArg() {
        Sqrt sqrt5 = new Sqrt(5.0, DELTA);
        assertEquals(Math.sqrt(5.0), sqrt5.calc(), DELTA);
    }

    @Test
    void sqrtWithDifferentDelta() {
        Sqrt sqrtSmallDelta = new Sqrt(ARG, 0.00001);
        assertEquals(Math.sqrt(ARG), sqrtSmallDelta.calc(), 0.00001);
    }

    @Test
    void sqrtOfSmallNumber() {
        Sqrt sqrtSmall = new Sqrt(0.0001, DELTA);
        assertEquals(0.01, sqrtSmall.calc(), DELTA);
    }
}

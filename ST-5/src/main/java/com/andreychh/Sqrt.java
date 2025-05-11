package com.andreychh;

public class Sqrt {
    private final double delta;
    private final double arg;

    public Sqrt(double arg, double delta) {
        this.arg = arg;
        this.delta = delta;
    }

    public double average(double x, double y) {
        return (x + y) / 2.0;
    }

    public boolean good(double guess, double x) {
        return Math.abs(guess * guess - x) < delta;
    }

    public double improve(double guess, double x) {
        return average(guess, x / guess);
    }

    public double iter(double guess, double x) {
        if (good(guess, x)) {
            return guess;
        } else {
            return iter(improve(guess, x), x);
        }
    }

    public double calc() {
        return iter(1.0, arg);
    }
}

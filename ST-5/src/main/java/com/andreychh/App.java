package com.andreychh;

public class App {
    public static void main(String[] args) {
        double num = 2.0;
        Sqrt sqrt = new Sqrt(num, 0.00000001);
        System.out.println("Sqrt of " + num + " is " + sqrt.calc());
    }
}

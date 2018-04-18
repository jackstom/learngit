package com.junit.calculator;

public class Calculator {
    static int add(int i, int j) {
    return i + j;
}

    int divide(int i, int j) {
        if(j==0)
            return 0;
        return i / j;
    }

    int multiple(int i, int j) {
        return i * j;
    }
}


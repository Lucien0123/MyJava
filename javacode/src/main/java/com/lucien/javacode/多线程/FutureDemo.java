package com.lucien.javacode.多线程;

import java.math.BigDecimal;

public class FutureDemo {

    public static void main(String[] args) {

        BigDecimal b1 = new BigDecimal("100000.123");
        System.out.println(b1.precision());
        System.out.println(b1.scale());
    }
}

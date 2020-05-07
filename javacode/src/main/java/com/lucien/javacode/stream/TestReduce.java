package com.lucien.javacode.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class TestReduce {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //做逻辑
        stream.reduce(Integer :: sum).ifPresent(System.out::println);
//        stream.reduce((i, j) -> i > j ? j : i).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求逻辑求乘机
        int result2 = stream.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);

        Optional.of(result2).ifPresent(System.out::println);
    }
}

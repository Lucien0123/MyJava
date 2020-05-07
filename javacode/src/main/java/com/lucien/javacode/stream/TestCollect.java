package com.lucien.javacode.stream;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollect {

    static class ObjDemo implements Supplier<ObjDemo> {
        String v1;
        String v2;

        public ObjDemo() {}

        public ObjDemo(String v1, String v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public String getV1() {
            return v1;
        }

        public void setV1(String v1) {
            this.v1 = v1;
        }

        public String getV2() {
            return v2;
        }

        public void setV2(String v2) {
            this.v2 = v2;
        }

        @Override
        public ObjDemo get() {
            return new ObjDemo("name"+new Random().nextInt(100)+new Random().nextInt(100), "test");
        }

        @Override
        public String toString() {
            return "ObjDemo{" +
                    "v1='" + v1 + '\'' +
                    ", v2='" + v2 + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Stream<ObjDemo> stream = Stream.generate(new ObjDemo()).limit(10);
//        stream.forEach(System.out::println);
        Map<Object, Object> map = stream.collect(Collectors.toMap(ObjDemo::getV1, Function.identity()));
        map.forEach((k, v) -> System.out.println(k + "--" + v));
    }
}

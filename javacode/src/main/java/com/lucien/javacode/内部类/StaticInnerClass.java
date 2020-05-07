package com.lucien.javacode.内部类;

import java.util.Date;

public class StaticInnerClass {

    private String name;
    private static String age = "18";

    static class InnerClass{
        private static String _name1 = "inner";

        public static void display() {
            System.out.println("OutClass age :" + age);
        }
    }

    public void display() {
        System.out.println("Inner Class Name：" + InnerClass._name1);
        InnerClass.display();
    }

    public static void main(String[] args) {
//        StaticInnerClass clazz = new StaticInnerClass();
//        clazz.display();
        System.out.println(new Date(1545148799643L));
    }
}

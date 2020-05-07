package com.lucien.javacode.内部类;

public class MemberInnerClass {

    private String name;

    public void outerDispay() {
        System.out.println("outer class...");
    }

    class InnerClass {

        public void innerDisplay() {
            name = "inner set";
            System.out.println(name);
            outerDispay();
        }
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    public static void main(String[] args) {
        MemberInnerClass outerClass = new MemberInnerClass();
        InnerClass innerClass = outerClass.getInnerClass();
        innerClass.innerDisplay();
    }
}

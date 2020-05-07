package com.lucien.javacode.内部类的一个问题;/**
/**
 * God bless me!!!
 *
 * @Description : 测试内部类的访问限制
 * @Author : lucien
 * @Date : 2018-04-04 上午9:54
 */
public class OuterClass {

    /**
     * 写一些笔记：
     */
    private class InnerClass {
        public final int a = 0;

        private InnerClass() {
            System.out.println("im inner class init...");
        }

        public void funInnerA() {
            System.out.println("im inner class function aaa...");
        }
    }

    public OuterClass() {
        /**
         *
         * */
        // System.out.println(a);   // 编译报错，根据内存的单链表性质，外部类找不到内部类的filed、method
        // funInnerA();
        InnerClass innerClass = new InnerClass();  // 这里调用构造函数相当于是new 运算符调用的，与内部外部类无关
        System.out.println("im outer class init...");
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
    }

}

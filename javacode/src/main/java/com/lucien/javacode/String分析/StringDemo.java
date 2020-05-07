package com.lucien.javacode.String分析;

/**
 * Created by lucien on 2017/11/22.
 */
public class StringDemo {

    public static void main(String[] args) {
        String s = new String();

        StringBuilder sb = new StringBuilder();
        sb.append("123");

        /* StringBuilder的最小长度是16个字节;
         * StringBuilder可以看在String的可变配套类，String是一个不可变类，在初始化设定值后不可以在改变，
         * String的replace()操作返回的是一个新的对象而不是this；
         * StringBuilder同样可以看做是一个任意长度的位序列，但其append()返回的是this，即在修改初始化时的对象
         * 这个可变配套类在一定程度上有用，例如：
         *  1、定义一个字符串："123456789"；
         *  2、想修改末尾的值为：9 --> 8;
         *  3、对于String而言，会返回一个新的字符串对象，此时会存在两个对象："123456789" ，"123456788"；
         *  4、使用StringBuilder则可以替换初始化时的字符串"123456789" --> "123456788"，只存在一个对象；
         *  5、这种情况在当字符串非常长时，用StringBuilder可以有效的节约空间。
         *  */

        /*
        * String对象是使用int定义的count来记录字符的数量的， */

    }
}

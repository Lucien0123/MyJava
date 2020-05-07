package com.lucien.javacode.建造者模式;

/**
 * Created by lucien on 2018/2/23.
 */
public class BuilderDemo {

    private String name;
    private int age;

    private static BuilderDemo instance;

    private BuilderDemo(){
        System.out.println("BuilderDemo init...");
    }

    public static BuilderDemo create(){
        instance = new BuilderDemo();
        return instance;
    }

    public BuilderDemo setName(String name){
        this.name = name;
        return this;
    }

    public BuilderDemo setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "BuilderDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class BuilderTest{
    public static void main(String[] args) {
        BuilderDemo builderDemo = BuilderDemo.create().setName("zhangsan").setAge(22);
        System.out.println(builderDemo.toString());
    }
}

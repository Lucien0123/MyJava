package com.lucien.javacode.Optional用法;

import cn.lucien.javademo.Optional用法.model.SubModel;
import cn.lucien.javademo.Optional用法.model.TestModel;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 参考博客地址：https://www.cnblogs.com/zhangboyu/p/7580262.html
 */

public class OptionalDemo {

    @Test
    public void createOptional() {
        Optional<TestModel> empty = Optional.empty();

        TestModel testModel = new TestModel();
        testModel = null;
        Optional<TestModel> o1 = Optional.ofNullable(testModel);
        assertTrue(o1.isPresent());
        o1.ifPresent(obj -> {
            System.out.println("当不空的情况下进行的展示。。。");
        });
    }

    @Test
    public void returnDefault() {
        TestModel nullObj = null;
        TestModel obj = new TestModel();

        // 如果nullObj为空的时候，使用默认值obj
        TestModel ooo = Optional.ofNullable(nullObj).orElse(obj);

        assertTrue(ooo != null);

        TestModel oo1 = Optional.ofNullable(nullObj).orElseGet(() -> {
            System.out.println("相对于orElse方法而言，创建一个新的对象并返回设置默认值");
            return new TestModel();
        });
        assertTrue(oo1 != null);


        /* 当对象不空的情况 */
        TestModel obj1 = new TestModel();
        System.out.println("使用orElse为Optional设置默认值时，始终都会创建一个对象作为默认值。。");
        TestModel oo2 = Optional.ofNullable(obj1).orElse(createObj());

        System.out.println("使用orElseGet为Optional设置默认值时，只会在对象为空的时候创建对象！！");
        TestModel oo3 = Optional.ofNullable(obj1).orElseGet(() -> createObj());
    }

    @Test
    public void test_nullThrowsException() {
        /* 当对象为空时，自定义抛出的异常类型，但只能有一个整体的异常处理方案 */
        TestModel obj = null;
        TestModel ooo = Optional.ofNullable(obj).orElseThrow(() -> {
            System.out.println("当对象为空的时候，我抛出了一个自定义的异常，谁关心谁处理吧");
            return new IllegalStateException("errorCode： 10011");
        });
    }


    @Test
    public void test_filterVal() {
        TestModel testModel = new TestModel();
        SubModel subModel = new SubModel();
        subModel.setClassName("className");
        testModel.setClazz(subModel);
        testModel.setIntVal(0);
        testModel.setListVal(new ArrayList<>());
        testModel.setStringVal("str");

        String str = Optional.ofNullable(testModel)
                .map(obj -> obj.getStringVal())
                .filter(s -> s.length() > 0)
                .orElse("kong");
        assertTrue(StringUtils.isNotBlank(str));

        String className = Optional.ofNullable(testModel)
                .map(TestModel::getClazz)
                .map(SubModel::getClassName)
                .filter(s -> s.length() > 100)
                .orElse("default");

        System.out.println(className);

    }

    @Test
    public void test_result() {
        TestModel testModel = null;
        SubModel subModel = null;
        String className1 = Optional.ofNullable(testModel)
                .map(TestModel::getClazz)
                .map(SubModel::getClassName)
                .orElse("default");

        System.out.println("className1: " + className1);

        TestModel testModel2 = new TestModel();
        SubModel subModel2 = null;
//        subModel.setClassName("className");
        testModel2.setClazz(subModel2);
        testModel2.setIntVal(0);
        testModel2.setListVal(new ArrayList<>());
        testModel2.setStringVal("str");
        String className2 = Optional.ofNullable(testModel2)
                .map(TestModel::getClazz)
                .map(SubModel::getClassName)
                .orElse("default");
        System.out.println("className2: " + className2);

        TestModel testModel3 = new TestModel();
        SubModel subModel3 = new SubModel();
        subModel3.setClassName("className");
        testModel3.setClazz(subModel3);
        testModel3.setIntVal(0);
        testModel3.setListVal(new ArrayList<>());
        testModel3.setStringVal("str");
        String className3 = Optional.ofNullable(testModel3)
                .map(TestModel::getClazz)
                .map(SubModel::getClassName)
                .filter(s -> s.length() > 1)
                .orElse("default");
        System.out.println("className3: " + className3);
    }


    public TestModel createObj() {
        System.out.println("创建一个TestModel并返回！！！");
        return new TestModel();
    }

    @Test
    public void test_1 () {
        String str = null;
        String defaults = "默认字符串...";
        System.out.println(Optional.ofNullable(str).orElse(defaults));
    }
}
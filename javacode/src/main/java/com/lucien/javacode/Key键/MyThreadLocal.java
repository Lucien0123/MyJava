package com.lucien.javacode.Key键;

/**
 * Created by lucien on 2017/11/23.
 */
public final class MyThreadLocal<T> {

    private T value1;

    public MyThreadLocal(){}

    public void set(T value) {
        value1 = value;
    }

    public T get(){
        return value1;
    }
}

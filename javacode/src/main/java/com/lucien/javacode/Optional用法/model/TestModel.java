package com.lucien.javacode.Optional用法.model;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class TestModel {

    private String stringVal;

    private int intVal;

    private List<String> listVal;

    private SubModel clazz;

    public Optional<SubModel> getClazz1() {
        return Optional.ofNullable(clazz);
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public List<String> getListVal() {
        return listVal;
    }

    public void setListVal(List<String> listVal) {
        this.listVal = listVal;
    }

    public SubModel getClazz() {
        return clazz;
    }

    public void setClazz(SubModel clazz) {
        this.clazz = clazz;
    }
}

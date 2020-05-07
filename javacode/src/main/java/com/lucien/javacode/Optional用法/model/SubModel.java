package com.lucien.javacode.Optional用法.model;

import lombok.Data;

import java.util.Optional;

@Data
public class SubModel {

    private String className;

    private String gradeName;

    public Optional<String> getClassName1() {
        return Optional.ofNullable(className);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}

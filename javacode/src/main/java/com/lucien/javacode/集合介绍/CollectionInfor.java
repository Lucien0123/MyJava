package com.lucien.javacode.集合介绍;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lucien on 2018/2/22.
 */
public class CollectionInfor {
    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        Set<String> b = new HashSet<>();

        Map<String, Object> c = new HashMap<>();
        Map<String, Object> d = new ConcurrentHashMap<>();
        d.put("", "");
    }
}

package com.lucien.javacode.缓存应用;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lucien on 2017/11/28.
 * 以局部变量map结构缓存部分业务数据，减少频繁的重复数据库I/O操作。
 * 缺点仅限于类的自身作用域内，类间无法共享缓存。
 */
public class LocalCacheUse {

    public void useLocalCache(){
        /* 定义一个本地缓存的变量 */
        Map<String, Object> localCacheStoreMap = new HashMap<>();
        List<Object> inforList = this.getInforList();

        for(Object obj : inforList){
            if (localCacheStoreMap.containsKey(obj)){
                /* 找到了对应Key的值，输出 */
            } else {
                /* 加入在本地的缓存中没有找到则从数据库中查询，进行I/O，然后将取到的数据存到缓存中 */
                Object data = getDataFromDatabase();
                localCacheStoreMap.put(obj.toString(), data);
            }
        }
    }

    private List<Object> getInforList(){
        return new ArrayList<>();
    }

    /* 模拟I/O操作 */
    private Object getDataFromDatabase(){
        /* 假装从数据库中取数据的操作 */
        return new Object();
    }


}

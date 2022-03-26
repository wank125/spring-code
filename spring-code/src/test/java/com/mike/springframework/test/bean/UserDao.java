package com.mike.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小战");
        hashMap.put("10002", "小李");
        hashMap.put("10003", "小刘");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}

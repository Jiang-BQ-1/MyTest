package com.example.mytest.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheManager {

    public static Map<String, List<String>> User_Roles = new HashMap<String, List<String>>();

    static {
        List<String> roles = new ArrayList<String>();
        roles.add("admin");
        roles.add("user");
        List<String> roles2 = new ArrayList<String>();
        roles2.add("user");
        User_Roles.put("zhangSan", roles);
        User_Roles.put("liSi", roles2);
    }
}

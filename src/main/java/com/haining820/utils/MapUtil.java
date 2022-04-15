package com.haining820.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    public static Map<String, Object> returnMap(int res) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (res == 1) {
            map.put("status", 1);
        } else if (res == -1) {
            map.put("status", -1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

}

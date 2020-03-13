package com.supervisory.board.utils;

import java.util.HashMap;
import java.util.Map;

import static com.supervisory.board.utils.Constants.API_AUTHORITY;
import static com.supervisory.board.utils.Constants.TOKEN;

public class Headers {
    public static Map<String, String> getAuthorityMap() {
        Map<String, String> map = new HashMap<>();
        map.put(API_AUTHORITY, TOKEN);
        return map;
    }
}

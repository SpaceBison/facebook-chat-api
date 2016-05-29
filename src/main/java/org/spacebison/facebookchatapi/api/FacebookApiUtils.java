package org.spacebison.facebookchatapi.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cmb on 29.05.16.
 */
class FacebookApiUtils {

    public static Map<String, String> makeMap(String name, List<? extends Object> list) {
        HashMap<String, String> map = new HashMap<>(list.size());

        for (int i = 0; i < list.size(); ++i) {
            map.put(name + '[' + i + ']', list.get(i).toString());
        }

        return map;
    }

    public static Map<String, String> makeMapFromMaps(String name, List<Map<String, ? extends Object>> listMap) {
        HashMap<String, String> newMap = new HashMap<>(listMap.size());

        for (int i = 0; i < listMap.size(); ++i) {
            Map<String, ? extends Object> map = listMap.get(i);

            for (Map.Entry<String, ? extends Object> e : map.entrySet()) {
                newMap.put(name + '[' + i + ']' + e.getKey(), e.getValue().toString());
            }
        }

        return newMap;
    }
}

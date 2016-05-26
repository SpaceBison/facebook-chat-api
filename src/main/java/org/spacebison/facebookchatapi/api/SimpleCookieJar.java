package org.spacebison.facebookchatapi.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by cmb on 23.05.16.
 */
public class SimpleCookieJar implements CookieJar {
    private final HashMap<HttpUrl, ArrayList<Cookie>> mMap = new HashMap<>();

    @Override
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        System.out.println("Save for " + httpUrl + " : " + list);
        if (!mMap.containsKey(httpUrl)) {
            mMap.put(httpUrl, new ArrayList<>(list));
        } else {
            mMap.get(httpUrl).addAll(list);
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        LinkedList<Cookie> cookies = new LinkedList<>();
        String reverseHost = new StringBuilder(httpUrl.host()).reverse().toString();
        String reverseDomain = reverseHost.substring(0, reverseHost.indexOf('.', reverseHost.indexOf('.') + 1));

        for (HttpUrl key : mMap.keySet()) {
            String keyReverseHost = new StringBuilder(key.host()).reverse().toString();

            if (keyReverseHost.startsWith(reverseDomain)) {
                cookies.addAll(mMap.get(key));
            }
        }
        System.out.println("Load for " + httpUrl + " : " + cookies);
        return cookies;
    }
}

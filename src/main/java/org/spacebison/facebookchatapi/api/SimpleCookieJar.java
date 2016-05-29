package org.spacebison.facebookchatapi.api;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
    private final HashMap<String, HashMap<String, Cookie>> mMap = new HashMap<>();

    @Override
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        String reverseDomain = getReverseDomain(httpUrl);

        System.out.println("Save for " + httpUrl + " (" + reverseDomain + "): ");

        HashMap<String, Cookie> newCookieMap = new HashMap<>(list.size());

        for (Cookie c : list) {
            if ("deleted".equals(c.value()) || "".equals(c.value())) {
                System.out.println("  delete cookie: " + toString(c));
                mMap.get(reverseDomain).remove(c.name());
            } else {
                System.out.println("  " + toString(c));
                newCookieMap.put(c.name(), c);
            }
        }

        if (!mMap.containsKey(reverseDomain)) {
            mMap.put(reverseDomain, newCookieMap);
        } else {
            mMap.get(reverseDomain).putAll(newCookieMap);
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        LinkedList<Cookie> cookies = new LinkedList<>();
        String reverseDomain = getReverseDomain(httpUrl);

        for (String key : mMap.keySet()) {

            if (key.startsWith(reverseDomain)) {
                cookies.addAll(mMap.get(key).values());
            }
        }

        System.out.println("Load for " + httpUrl + " (" + reverseDomain + "): ");

        for (Cookie c : cookies) {
            System.out.println("  " + toString(c));
        }

        return cookies;
    }

    private String getReverseDomain(HttpUrl httpUrl) {
        String reverseHost = new StringBuilder(httpUrl.host()).reverse().toString();
        return reverseHost.substring(0, reverseHost.indexOf('.', reverseHost.indexOf('.') + 1));
    }

    private String toString(Cookie cookie) {
        String value;
        try {
            value = URLDecoder.decode(cookie.value(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //noinspection deprecation
            value = URLDecoder.decode(cookie.value());
        }
        return cookie.name() + " = " + value;
    }
}

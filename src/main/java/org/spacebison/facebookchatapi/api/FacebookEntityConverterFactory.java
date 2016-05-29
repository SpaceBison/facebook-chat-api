package org.spacebison.facebookchatapi.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.spacebison.facebookchatapi.generated.js2p.Batch;
import org.spacebison.facebookchatapi.generated.js2p.ChatproxyPresence;
import org.spacebison.facebookchatapi.generated.js2p.FacebookEntity;
import org.spacebison.facebookchatapi.generated.js2p.FullReload;
import org.spacebison.facebookchatapi.generated.js2p.Lb;
import org.spacebison.facebookchatapi.generated.js2p.Ms;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by cmb on 29.05.16.
 */
public class FacebookEntityConverterFactory extends Converter.Factory {
    private static FacebookEntityConverterFactory sInstance;

    public static FacebookEntityConverterFactory create() {
        if (sInstance == null) {
            synchronized (FacebookEntityConverterFactory.class) {
                if (sInstance == null) {
                    sInstance = new FacebookEntityConverterFactory();
                }
            }
        }

        return sInstance;
    }

    @Override
    public retrofit2.Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new Converter();
    }

    private static class Converter implements retrofit2.Converter<ResponseBody, FacebookEntity> {
        private static final Gson GSON = new GsonBuilder()
                .registerTypeAdapter(
                        FacebookEntity.class,
                        new GsonDeserializerBuilder<FacebookEntity>("t", FacebookEntity.class)
                                .addType("batched", Batch.class)
                                .addType("lb", Lb.class)
                                .addType("fullReload", FullReload.class)
                                .buildDeserializer())
                .registerTypeAdapter(
                        Ms.class,
                        new GsonDeserializerBuilder<>("type", Ms.class)
                        .addType("chatproxy-presence", ChatproxyPresence.class)
                        .buildDeserializer())
                .create();
        private static final Pattern JSON = Pattern.compile("\\{.*\\}");

        private static String extractJson(String string) {
            Matcher matcher = JSON.matcher(string);

            if (matcher.find()) {
                return matcher.group();
            } else {
                return null;
            }
        }

        @Override
        public FacebookEntity convert(ResponseBody value) throws IOException {
            String json = extractJson(value.string());
            return GSON.fromJson(json, FacebookEntity.class);
        }
    }
}


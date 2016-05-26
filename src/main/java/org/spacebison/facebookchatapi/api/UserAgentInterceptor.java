package org.spacebison.facebookchatapi.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by cmb on 23.05.16.
 */
public class UserAgentInterceptor implements Interceptor {
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("User-Agent", USER_AGENT)
                .build();
        return chain.proceed(request);
    }
}

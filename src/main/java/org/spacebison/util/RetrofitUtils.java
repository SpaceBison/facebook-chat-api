package org.spacebison.util;

import java.io.IOException;

import okhttp3.Request;
import okio.Buffer;
import retrofit2.Response;

/**
 * Created by cmb on 22.05.16.
 */
public class RetrofitUtils {
    public static String toString(Response response) {
        return "Response{" +
                "code: " + response.code() +
                "\n\nsuccess: " + response.isSuccessful() +
                "\n\nheaders:\n" + response.headers() +
                "\n\nbody:\n" + response.body();
    }

    public static String bodyToString(final Request request){
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
                return "did not work";
            }
        }
}

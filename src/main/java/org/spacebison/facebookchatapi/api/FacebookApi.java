package org.spacebison.facebookchatapi.api;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by cmb on 22.05.16.
 */
public interface FacebookApi {
    public static final String BASE_URL = "https://www.facebook.com";

    @GET("/")
    Call<String> mainPage();

    @FormUrlEncoded
    @POST("ajax/presence/reconnect.php")
    Call<String> reconnect(@Field("reason") int reason);

    @FormUrlEncoded
    @POST("login")
    Call<String> login(@Query("login_attempt") int loginAttempt,
                       @Query("lwv") int lwv,
                       @Field("email") String email,
                       @Field(value = "pass", encoded = true) String pass,
                       @Field("default_persistent") int defaultPersistent,
                       @FieldMap Map<String, String> formData);

    /*
    @FormUrlEncoded
    @POST("login")
    Call<String> login(@Query("login_attempt") int loginAttempt,
                       @Query("lwv") int lwv,
                       @Field("lsd") String lsd,
                       @Field("lgndim") String lgndim,
                       @Field("email") String email,
                       @Field(value = "pass", encoded = true) String pass,
                       @Field("default_persistent") int defaultPersistent,
                       @Field("lgnrnd") String lgnrd,
                       @Field("locale") String locale,
                       @Field("timezone") int timezone,
                       @Field("lgnjs") long lgnjs);
                       */
}

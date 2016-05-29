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

    @GET("ajax/presence/reconnect.php")
    Call<String> reconnect(@Query("reason") int reason,
                           @Query("__user") String user,
                           @Query("__a") int a,
                           @Query("__dyn") String dyn,
                           @Query("__req") int req,
                           @Query("__be") int be,
                           @Query("__pc") String pc,
                           @Query("__rev") int rev,
                           @Query("fb_dtsg") String fbDtsg);

    /*
@Query("__user:100011911477064
@Query("__a:1
@Query("__dyn:5V5yAW8-aFoAwmgDxKy1l0AhEK5EK8GAEG8zQC-C26m6oDAyoeAq8zUK5U4e2O3J1Zi28cZ1eUPBKuEjKeCwxxW3Ouum2SUpGqewIxWcx278mxK229yoOmmEK48hw
@Query("__req:3
@Query("__be:0
@Query("__pc:PHASED:DEFAULT
@Query("__rev:2362226
@Query("reason:6
@Query("fb_dtsg:AQG15xAkWyi4:AQGdWVFDl0UI
     */

    @FormUrlEncoded
    @POST("login")
    Call<String> login(@Query("login_attempt") int loginAttempt,
                       @Query("lwv") int lwv,
                       @Field("email") String email,
                       @Field(value = "pass", encoded = true) String pass,
                       @Field("default_persistent") int defaultPersistent,
                       @FieldMap Map<String, String> formData);

    
    @FormUrlEncoded
    @POST("chat/user_info_all")
    Call<String> userInfoAll(@Field("viewer") String userId);
    
}

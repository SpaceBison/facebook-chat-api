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

    @FormUrlEncoded
    @POST("ajax/mercury/send_messages.php?")
    Call<String> sendMessages(@Query("dpr") int dpr,
                              @Field("client") String client,
                              @Field("__user") String user,
                              @Field("__a") int a,
                              @Field("__dyn") String dyn,
                              @Field("__req") String req,
                              @Field("__be") int be,
                              @Field("__pc") String pc,
                              @Field("fb_dtsg") String fbDtsg,
                              @Field("ttstamp") String timestamp,
                              @Field("__rev") String rev,
                              @FieldMap Map<String, String> messageBatches);

        /*
@Field("client") :mercury
@Field("__user") :1068646706
@Field("__a") :1
@Field("__dyn") :5V5yAW8-aFoAwmgDxyIGzGomyp9EbEyGgS8zCC-C26m6oKewWhEyfyUnwgUb8f8vkwy3fgjKcDKuEjKeCxicxW3uiuum2SUpGqewIUsz8gCxm5ErwwyoCcBBGbx24o
@Field("__req") :1t
@Field("__be") :0
@Field("__pc") :PHASED") :DEFAULT
@Field("fb_dtsg") :AQEpB0Jmiuqw") :AQGEJPoe8gKB
@Field("ttstamp") :265816911266487410910511711311958658171697480111101561037566
@Field("__rev") :2362226
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

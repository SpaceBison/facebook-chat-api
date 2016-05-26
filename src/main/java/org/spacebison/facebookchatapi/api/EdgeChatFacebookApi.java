package org.spacebison.facebookchatapi.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by cmb on 22.05.16.
 */
public interface EdgeChatFacebookApi {
    public static final String BASE_URL = "https://0-edge-chat.facebook.com";

    @FormUrlEncoded
    @POST
    Call<String> pull(@Field("channel") String channel,
                      @Field("seq") int seq,
                      @Field("partition") int partition,
                      @Field("clientid") String clientId,
                      @Field("viewer_uid") String viewerUid,
                      @Field("uid") String uid,
                      @Field("state") String state,
                      @Field("idle") int idle,
                      @Field("cap") int cap,
                      @Field("msgs_recv") int msgsRecv);
}

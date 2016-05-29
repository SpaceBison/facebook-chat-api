package org.spacebison.facebookchatapi.api;

import org.spacebison.facebookchatapi.generated.js2p.Batch;

import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.http.GET;

/**
 * Created by cmb on 22.05.16.
 */
public interface EdgeChatFacebookApi {
    public static final String BASE_URL = "https://1-edge-chat.facebook.com";

    @GET("pull")
    Call<Batch> pull(@Query("channel") String channel,
                     @Query("seq") int seq,
                     @Query("partition") int partition,
                     @Query("clientid") String clientId,
                     @Query("cb") String cb,
                     @Query("qp") String qp,
                     @Query("pws") String pws,
                     @Query("isq") int isq,
                     @Query("viewer_uid") String viewerUid,
                     @Query("uid") String uid,
                     @Query("request_batch") int requestBatch,
                     @Query("msgr_region") String msdgrRegion,
                     @Query("state") String state,
                     @Query("idle") int idle,
                     @Query("cap") int cap,
                     @Query("msgs_recv") int msgsRecv);

        /*
    https://1-edge-chat.facebook.com/pull?channel=p_100011911477064
&seq=1
&partition=-2
&clientid=4fdb6d8
&cb=cbvq
&idle=1
&qp=y
&cap=8
&pws=fresh
&isq=5
&msgs_recv=0
&uid=100011911477064
&viewer_uid=100011911477064
&sticky_token=168
&sticky_pool=frc3c09_chat-proxy
&state=active
     */
}

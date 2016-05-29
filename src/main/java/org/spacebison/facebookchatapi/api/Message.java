package org.spacebison.facebookchatapi.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cmb on 29.05.16.
 */
public class Message implements FormSerializable {
    private boolean mFilteredContent = false;
    private boolean mFilteredContentAccount = false;
    private boolean mFilteredContentBh = false;
    private boolean mFilteredContentInvalidApp = false;
    private boolean mFilteredContentQuasar = false;
    private boolean mForward = false;
    private boolean mHasAttachment = false;
    private boolean mHtmlBody = false;
    private boolean mSpoofWarning = false;
    private boolean mUnread = false;
    private int mEphemeralTtlMode;
    private int mManualRetryCnt;
    private int mOtherUserFbid;
    private int mStatus = 0;
    private List<String> mSourceTags = Collections.singletonList("source:chat");
    private List<String> mSpecificToList = new ArrayList<>(2);
    private String mActionType = "ma-type:user-generated-message";
    private String mAuthor;
    private String mAuthorEmail;
    private String mBody;
    private String mMessageId;
    private String mOfflineThreadingId;
    private String mSource = "source:chat:web";
    private String mThreadId;
    private String mTimestamp;
    private String mTimestampAbsoulte;
    private String mTimestampRelative;
    private String mTimestampTimePassed;
    private String mUiPushPhase;

    public String getActionType() {
        return mActionType;
    }

    public void setActionType(String actionType) {
        mActionType = actionType;
    }

    public String getThreadId() {
        return mThreadId;
    }

    public void setThreadId(String threadId) {
        mThreadId = threadId;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getAuthorEmail() {
        return mAuthorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        mAuthorEmail = authorEmail;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

    public String getTimestampAbsoulte() {
        return mTimestampAbsoulte;
    }

    public void setTimestampAbsoulte(String timestampAbsoulte) {
        mTimestampAbsoulte = timestampAbsoulte;
    }

    public String getTimestampRelative() {
        return mTimestampRelative;
    }

    public void setTimestampRelative(String timestampRelative) {
        mTimestampRelative = timestampRelative;
    }

    public String getTimestampTimePassed() {
        return mTimestampTimePassed;
    }

    public void setTimestampTimePassed(String timestampTimePassed) {
        mTimestampTimePassed = timestampTimePassed;
    }

    public boolean isUnread() {
        return mUnread;
    }

    public void setUnread(boolean unread) {
        mUnread = unread;
    }

    public boolean isForward() {
        return mForward;
    }

    public void setForward(boolean forward) {
        mForward = forward;
    }

    public boolean isFilteredContent() {
        return mFilteredContent;
    }

    public void setFilteredContent(boolean filteredContent) {
        mFilteredContent = filteredContent;
    }

    public boolean isFilteredContentBh() {
        return mFilteredContentBh;
    }

    public void setFilteredContentBh(boolean filteredContentBh) {
        mFilteredContentBh = filteredContentBh;
    }

    public boolean isFilteredContentAccount() {
        return mFilteredContentAccount;
    }

    public void setFilteredContentAccount(boolean filteredContentAccount) {
        mFilteredContentAccount = filteredContentAccount;
    }

    public boolean isFilteredContentQuasar() {
        return mFilteredContentQuasar;
    }

    public void setFilteredContentQuasar(boolean filteredContentQuasar) {
        mFilteredContentQuasar = filteredContentQuasar;
    }

    public boolean isFilteredContentInvalidApp() {
        return mFilteredContentInvalidApp;
    }

    public void setFilteredContentInvalidApp(boolean filteredContentInvalidApp) {
        mFilteredContentInvalidApp = filteredContentInvalidApp;
    }

    public boolean isSpoofWarning() {
        return mSpoofWarning;
    }

    public void setSpoofWarning(boolean spoofWarning) {
        mSpoofWarning = spoofWarning;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public List<String> getSourceTags() {
        return mSourceTags;
    }

    public void setSourceTags(List<String> sourceTags) {
        mSourceTags = sourceTags;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public boolean isHasAttachment() {
        return mHasAttachment;
    }

    public void setHasAttachment(boolean hasAttachment) {
        mHasAttachment = hasAttachment;
    }

    public boolean isHtmlBody() {
        return mHtmlBody;
    }

    public void setHtmlBody(boolean htmlBody) {
        mHtmlBody = htmlBody;
    }

    public List<String> getSpecificToList() {
        return mSpecificToList;
    }

    public void setSpecificToList(List<String> specificToList) {
        mSpecificToList = specificToList;
    }

    public String getUiPushPhase() {
        return mUiPushPhase;
    }

    public void setUiPushPhase(String uiPushPhase) {
        mUiPushPhase = uiPushPhase;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public String getOfflineThreadingId() {
        return mOfflineThreadingId;
    }

    public void setOfflineThreadingId(String offlineThreadingId) {
        mOfflineThreadingId = offlineThreadingId;
    }

    public String getMessageId() {
        return mMessageId;
    }

    public void setMessageId(String messageId) {
        mMessageId = messageId;
    }

    public int getEphemeralTtlMode() {
        return mEphemeralTtlMode;
    }

    public void setEphemeralTtlMode(int ephemeralTtlMode) {
        mEphemeralTtlMode = ephemeralTtlMode;
    }

    public int getManualRetryCnt() {
        return mManualRetryCnt;
    }

    public void setManualRetryCnt(int manualRetryCnt) {
        mManualRetryCnt = manualRetryCnt;
    }

    public int getOtherUserFbid() {
        return mOtherUserFbid;
    }

    public void setOtherUserFbid(int otherUserFbid) {
        mOtherUserFbid = otherUserFbid;
    }

    @Override
    public Map<String, String> asFieldMap() {
        HashMap<String, String> map = new HashMap<>(32);

        map.put("action_type", mActionType);
        map.put("thread_id", mThreadId);
        map.put("author", mAuthor);
        map.put("author_email", mAuthorEmail);
        map.put("timestamp", mTimestamp);
        map.put("timestamp_absolute", mTimestampAbsoulte);
        map.put("timestamp_relative", mTimestampRelative);
        map.put("timestamp_time_passed", mTimestampTimePassed);
        map.put("is_unread", Boolean.toString(mUnread));
        map.put("is_formward", Boolean.toString(mForward));
        map.put("is_filtered_content", Boolean.toString(mFilteredContent));
        map.put("is_filtered_content_bh", Boolean.toString(mFilteredContentBh));
        map.put("is_filtered_content_account", Boolean.toString(mFilteredContentAccount));
        map.put("is_filtered_content_quasar", Boolean.toString(mFilteredContentQuasar));
        map.put("is_filtered_content_invalid_app", Boolean.toString(mFilteredContentInvalidApp));
        map.put("is_spoof_warning", Boolean.toString(mSpoofWarning));
        map.put("source", mSource);
        map.putAll(FacebookApiUtils.makeMap("source_tags", mSourceTags));
        map.put("body", mBody);
        map.put("has_attachment", Boolean.toString(mHasAttachment));
        map.put("html_body", Boolean.toString(mHtmlBody));
        map.putAll(FacebookApiUtils.makeMap("specific_to_list", mSpecificToList));
        map.put("ui_push_phase", mUiPushPhase);
        map.put("status", Integer.toString(mStatus));
        map.put("offline_threading_id", mOfflineThreadingId);
        map.put("message_id", mMessageId);
        map.put("ephemeral_ttl_mode", Integer.toString(mEphemeralTtlMode));
        map.put("manual_retry_cnt", Integer.toString(mManualRetryCnt));
        map.put("other_user_fbid", Integer.toString(mOtherUserFbid));

        return map;
    }



    /*
    map.put("action_type]:ma-type:user-generated-message
map.put("thread_id]:
map.put("author]:fbid:1068646706
map.put("author_email]:
map.put("timestamp]:1464525239442
map.put("timestamp_absolute]:Today
map.put("timestamp_relative]:2:33pm
map.put("timestamp_time_passed]:0
map.put("is_unread]:false
map.put("is_forward]:false
map.put("is_filtered_content]:false
map.put("is_filtered_content_bh]:false
map.put("is_filtered_content_account]:false
map.put("is_filtered_content_quasar]:false
map.put("is_filtered_content_invalid_app]:false
map.put("is_spoof_warning]:false
map.put("source]:source:chat:web
map.put("source_tags][0]:source:chat
map.put("body]:elo
map.put("has_attachment]:false
map.put("html_body]:false
map.put("specific_to_list][0]:fbid:1512675702
map.put("specific_to_list][1]:fbid:1068646706
map.put("ui_push_phase]:V3
map.put("status]:0
map.put("offline_threading_id]:6142664069892867388
map.put("message_id]:6142664069892867388
map.put("ephemeral_ttl_mode]:0
map.put("manual_retry_cnt]:0
map.put("other_user_fbid]:1512675702
     */
}

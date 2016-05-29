
package org.spacebison.facebookchatapi.generated.js2p;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class ChatproxyPresence
    extends Ms
{

    @SerializedName("buddyList")
    @Expose
    private Map<String, Buddy> buddyList;
    @SerializedName("userIsIdle")
    @Expose
    private Boolean userIsIdle;
    @SerializedName("chatNotif")
    @Expose
    private Integer chatNotif;
    @SerializedName("gamers")
    @Expose
    private List<Object> gamers = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The buddyList
     */
    public Map<String, Buddy> getBuddyList() {
        return buddyList;
    }

    /**
     * 
     * @param buddyList
     *     The buddyList
     */
    public void setBuddyList(Map<String, Buddy> buddyList) {
        this.buddyList = buddyList;
    }

    /**
     * 
     * @return
     *     The userIsIdle
     */
    public Boolean getUserIsIdle() {
        return userIsIdle;
    }

    /**
     * 
     * @param userIsIdle
     *     The userIsIdle
     */
    public void setUserIsIdle(Boolean userIsIdle) {
        this.userIsIdle = userIsIdle;
    }

    /**
     * 
     * @return
     *     The chatNotif
     */
    public Integer getChatNotif() {
        return chatNotif;
    }

    /**
     * 
     * @param chatNotif
     *     The chatNotif
     */
    public void setChatNotif(Integer chatNotif) {
        this.chatNotif = chatNotif;
    }

    /**
     * 
     * @return
     *     The gamers
     */
    public List<Object> getGamers() {
        return gamers;
    }

    /**
     * 
     * @param gamers
     *     The gamers
     */
    public void setGamers(List<Object> gamers) {
        this.gamers = gamers;
    }

    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(buddyList).append(userIsIdle).append(chatNotif).append(gamers).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChatproxyPresence) == false) {
            return false;
        }
        ChatproxyPresence rhs = ((ChatproxyPresence) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(buddyList, rhs.buddyList).append(userIsIdle, rhs.userIsIdle).append(chatNotif, rhs.chatNotif).append(gamers, rhs.gamers).isEquals();
    }

}

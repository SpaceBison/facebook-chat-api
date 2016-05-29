
package org.spacebison.facebookchatapi.generated.js2p;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Buddy {

    @SerializedName("lat")
    @Expose
    private Integer lat;
    @SerializedName("p")
    @Expose
    private Integer p;
    @SerializedName("vc")
    @Expose
    private Integer vc;

    /**
     * 
     * @return
     *     The lat
     */
    public Integer getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(Integer lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The p
     */
    public Integer getP() {
        return p;
    }

    /**
     * 
     * @param p
     *     The p
     */
    public void setP(Integer p) {
        this.p = p;
    }

    /**
     * 
     * @return
     *     The vc
     */
    public Integer getVc() {
        return vc;
    }

    /**
     * 
     * @param vc
     *     The vc
     */
    public void setVc(Integer vc) {
        this.vc = vc;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lat).append(p).append(vc).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Buddy) == false) {
            return false;
        }
        Buddy rhs = ((Buddy) other);
        return new EqualsBuilder().append(lat, rhs.lat).append(p, rhs.p).append(vc, rhs.vc).isEquals();
    }

}

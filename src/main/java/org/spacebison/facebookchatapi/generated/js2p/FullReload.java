
package org.spacebison.facebookchatapi.generated.js2p;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class FullReload
    extends FacebookEntity
{

    @SerializedName("seq")
    @Expose
    private Integer seq;
    @SerializedName("u")
    @Expose
    private Integer u;
    @SerializedName("ms")
    @Expose
    private List<Ms> ms = new ArrayList<Ms>();

    /**
     * 
     * @return
     *     The seq
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 
     * @param seq
     *     The seq
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 
     * @return
     *     The u
     */
    public Integer getU() {
        return u;
    }

    /**
     * 
     * @param u
     *     The u
     */
    public void setU(Integer u) {
        this.u = u;
    }

    /**
     * 
     * @return
     *     The ms
     */
    public List<Ms> getMs() {
        return ms;
    }

    /**
     * 
     * @param ms
     *     The ms
     */
    public void setMs(List<Ms> ms) {
        this.ms = ms;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(seq).append(u).append(ms).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FullReload) == false) {
            return false;
        }
        FullReload rhs = ((FullReload) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(seq, rhs.seq).append(u, rhs.u).append(ms, rhs.ms).isEquals();
    }

}

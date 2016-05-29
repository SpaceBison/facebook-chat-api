
package org.spacebison.facebookchatapi.generated.js2p;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Lb
    extends FacebookEntity
{

    @SerializedName("lb_info")
    @Expose
    private Lb_info lb_info;

    /**
     * 
     * @return
     *     The lb_info
     */
    public Lb_info getLb_info() {
        return lb_info;
    }

    /**
     * 
     * @param lb_info
     *     The lb_info
     */
    public void setLb_info(Lb_info lb_info) {
        this.lb_info = lb_info;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(lb_info).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Lb) == false) {
            return false;
        }
        Lb rhs = ((Lb) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(lb_info, rhs.lb_info).isEquals();
    }

}

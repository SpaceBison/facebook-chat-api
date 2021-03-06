
package org.spacebison.facebookchatapi.generated.js2p;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class FacebookEntity {

    /**
     * 
     * Corresponds to the "t" property.
     * 
     */
    @SerializedName("t")
    @Expose
    private String type;

    /**
     * 
     * Corresponds to the "t" property.
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * Corresponds to the "t" property.
     * 
     * @param type
     *     The t
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FacebookEntity) == false) {
            return false;
        }
        FacebookEntity rhs = ((FacebookEntity) other);
        return new EqualsBuilder().append(type, rhs.type).isEquals();
    }

}

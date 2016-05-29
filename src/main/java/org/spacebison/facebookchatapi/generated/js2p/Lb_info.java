
package org.spacebison.facebookchatapi.generated.js2p;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Lb_info {

    @SerializedName("sticky")
    @Expose
    private String sticky;
    @SerializedName("pool")
    @Expose
    private String pool;

    /**
     * 
     * @return
     *     The sticky
     */
    public String getSticky() {
        return sticky;
    }

    /**
     * 
     * @param sticky
     *     The sticky
     */
    public void setSticky(String sticky) {
        this.sticky = sticky;
    }

    /**
     * 
     * @return
     *     The pool
     */
    public String getPool() {
        return pool;
    }

    /**
     * 
     * @param pool
     *     The pool
     */
    public void setPool(String pool) {
        this.pool = pool;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sticky).append(pool).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Lb_info) == false) {
            return false;
        }
        Lb_info rhs = ((Lb_info) other);
        return new EqualsBuilder().append(sticky, rhs.sticky).append(pool, rhs.pool).isEquals();
    }

}

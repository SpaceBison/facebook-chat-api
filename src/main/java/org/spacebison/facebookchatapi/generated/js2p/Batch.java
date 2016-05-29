
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
public class Batch
    extends FacebookEntity
{

    @SerializedName("batches")
    @Expose
    private List<FacebookEntity> batches = new ArrayList<FacebookEntity>();

    /**
     * 
     * @return
     *     The batches
     */
    public List<FacebookEntity> getBatches() {
        return batches;
    }

    /**
     * 
     * @param batches
     *     The batches
     */
    public void setBatches(List<FacebookEntity> batches) {
        this.batches = batches;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(batches).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Batch) == false) {
            return false;
        }
        Batch rhs = ((Batch) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(batches, rhs.batches).isEquals();
    }

}

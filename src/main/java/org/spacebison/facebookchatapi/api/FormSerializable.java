package org.spacebison.facebookchatapi.api;

import java.util.Map;

/**
 * Created by cmb on 29.05.16.
 */
// TODO: 29.05.16 find a better name for this interface
public interface FormSerializable {
    Map<String, String> asFieldMap();
}

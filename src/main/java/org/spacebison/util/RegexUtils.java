package org.spacebison.util;

import java.util.regex.Matcher;

/**
 * Created by cmb on 22.05.16.
 */
public class RegexUtils {
    public static String[] getGroups(Matcher matcher) {
        int groupCount = matcher.groupCount();

        if (groupCount == 0) {
            return new String[0];
        }

        String[] groups = new String[groupCount];
        for (int i = 0; i < groups.length; ++i) {
            groups[i] = matcher.group(i+1);
        }

        return groups;
    }
}

package util.converter;

import constant.Constants;

/**
 * StringConverter
 *
 * @author moku
 * @date 2023/7/21 22:52:27
 * @version 1.0
 */
public class StringConverter {
    
    /**
     * valueOf
     *
     * @param value 
     * @return java.lang.String
     */
    public static String valueOf(Object value) {
        if (value == null) {
            return null;
        }

        return value.toString();
    }

    /**
     * valueOfDefaultEmpty
     *
     * @param value 
     * @return java.lang.String
     */
    public static String valueOfDefaultEmpty(Object value) {
        if (value == null) {
            return Constants.STRING_EMPTY;
        }

        return value.toString();
    }
}

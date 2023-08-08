package util;

import constant.Constants;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * ComUtil
 * 
 * @author moku
 * @date 2023/8/4 17:57:45
 * @version 1.0
 */
public class ComUtil {

    /**
     * isEmpty
     *
     * @param obj 
     * @return boolean
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof Optional) {
            return ((Optional<?>) obj).isEmpty();
        } else if (obj instanceof String) {
            return Constants.STRING_EMPTY.equals(((String) obj).trim());
        } else if (obj instanceof CharSequence) {
            return (((CharSequence) obj).isEmpty());
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        } else if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        } else if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        } else {
            throw new IllegalArgumentException("Unsupported object type");
        }
    }

    /**
     * isNotEmpty
     *
     * @param obj 
     * @return boolean
     */
    public static boolean isNotEmpty(Object obj) {
        return!isEmpty(obj);
    }
}

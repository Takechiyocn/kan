package util;

import constant.Constants;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName ComUtil
 * @Description
 * @Author moku
 * @Date 2023/8/4 17:57
 * @Version 1.0
 */
public class ComUtil {

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

    public static boolean isNotEmpty(Object obj) {
        return!isEmpty(obj);
    }
}

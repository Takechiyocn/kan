package thread.thread;

import java.util.Map;

/**
 * @ClassName ThreadLocalUtil
 * @Description
 * @Author moku
 * @Date 2022/12/19 4:44
 * @Version 1.0
 */
public class ThreadLocalUtil {

    private static final ThreadLocal<Map<String, Object>> threadLocal = null;
//    private static final ThreadLocal<Map<String, Object>> threadLocal = new NamedThreadLocal("xxx-threadlocal") {
//        @Override
//        protected Map<String, Object> initialValue() {
//            return Maps.newHashMap();
//        }
//    };

    public static Map<String, Object> getThreadLocal() {
        return threadLocal.get();
    }

    public static <T> T get(String key) {
        Map map = threadLocal.get();
        // todo:copy a new one
        return (T) map.get(key);
    }

    public static <T> T get(String key, T defaultValue) {
        Map map = threadLocal.get();
        return (T) map.get(key) == null ? defaultValue : (T) map.get(key);
    }

    public static void set(String key, Object value) {
        Map map = threadLocal.get();
        map.put(key, value);
    }

    public static void set(Map<String, Object> keyValueMap) {
        Map map = threadLocal.get();
        map.putAll(keyValueMap);
    }

    public static void remove() {
        threadLocal.remove();
    }

}
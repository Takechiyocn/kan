package logic.interfacecustomize;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/27 23:06
 */
public interface AnotherNamed {
    /**
     * 默认方法重复定义
     * @return 信息
     */
    default String getName() {
        return getClass().getName() + "_" + hashCode() + " called AnotherNamed implements";
    }
}

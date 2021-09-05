package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射更改静态常量（java8/10以下可以使用）
 */
public class ReflectionRtTricky {
    public static void main(String args[]) throws Exception {
        setFinalStatic(Boolean.class.getField("FALSE"), true);

        System.out.format("Everything is %s", false); // "Everything is true"
    }

    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        /*java8/10(?)以上禁止
        Used to filter out fields and methods from certain classes from public
        view, where they are sensitive or they may contain VM-internal objects.
                These Maps are updated very rarely. Rather than synchronize on each access, we use copy-on-write。
                Reflection.class, ALL_MEMBERS,
                AccessibleObject.class, ALL_MEMBERS,
                Class.class, Set.of("classLoader", "classData"),
                ClassLoader.class, ALL_MEMBERS,
                Constructor.class, ALL_MEMBERS,
                Field.class, ALL_MEMBERS,
                Method.class, ALL_MEMBERS,
                Module.class, ALL_MEMBERS,
                System.class, Set.of("security")
         */
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        // 对于每一个域都有属于自己的修饰符。
        // field（public static final）修饰符进行按位与操作：
        //     field.getModifiers() & ~Modifier.FINAL
        //      ~Modifier.FINAL:去掉FINAL属性
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        // 没有final(常量)属性的域可以更改域值
        // 将默认的Boolean类定义的false更改为true
        field.set(null, newValue);
    }
}

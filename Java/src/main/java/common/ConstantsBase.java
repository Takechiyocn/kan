package common;

/**
 * @Author
 */
public class ConstantsBase {
    private String name;

    /**
     * class type
     */
    public static final String STRING_PARAMETER = "java.lang.String";
    public static final String DOUBLE_PARAMETER = "double";
    public static final String INTEGER_PARAMETER = "int";
    public static final String LONG_PARAMETER = "long";

    /**
     * Integer
     */
    public static final int INTEGER_1 = 1;
    public static final int INTEGER_2 = 2;
    public static final int INTEGER_3 = 3;

    /**
     * 特殊字符
     */
    public static final String ARRAY_MARK = "[]";



    public ConstantsBase(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

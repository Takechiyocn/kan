package common;

/**
 * @Author
 */
public class ConstantsBase {
    private String name;
    public static final String STRING_PARAMETER = "java.lang.String";
    public static final String DOUBLE_PARAMETER = "double";
    public static final String INTEGER_PARAMETER = "int";

    public ConstantsBase(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

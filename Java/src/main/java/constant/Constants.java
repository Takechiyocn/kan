package constant;

/**
 * @Author
 */
public class Constants {
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
    public static final String SIGN_ARRAY = "[]";
    public static final String SIGN_ASTERISK = "*";

    /**
     * Integer
     */
    public static final Integer INTEGER_0 = 0;

    /**
     * String
     */
    public static final String STRING_EMPTY = "";
    public static final String STRING_ONE = "1";
    public static final String STRING_TWO = "2";
    public static final String STRING_THREE = "3";
    public static final String STRING_FOUR = "4";
    public static final String STRING_FIVE = "5";
    public static final String STRING_SIX = "6";
    public static final String STRING_SEVEN = "7";
    public static final String STRING_EIGHT = "8";
    public static final String STRING_NINE = "9";
    public static final String STRING_TEN = "10";

    public Constants(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

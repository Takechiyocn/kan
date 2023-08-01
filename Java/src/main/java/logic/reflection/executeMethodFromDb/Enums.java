package logic.reflection.executeMethodFromDb;

import constant.Constants;

/**
 *
 */
public class Enums {

    /**
     *
     */
    public enum ParameterTypes {
        // java.lang.String
        STRING(Constants.STRING_PARAMETER),
        // double
        DOUBLE(Constants.DOUBLE_PARAMETER),
        // int
        INT(Constants.INTEGER_PARAMETER),
        // long
        LONG(Constants.LONG_PARAMETER);

        private String extended;

        private ParameterTypes(String extended) {
            this.extended = extended;
        }

        public String getExtended() {
            return extended;
        }
    }
}

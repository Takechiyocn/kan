package reflection.executeMethodFromDb;

import common.ConstantsBase;

/**
 *
 */
public class Enums {

    /**
     *
     */
    public enum ParameterTypes {
        // java.lang.String
        STRING(ConstantsBase.STRING_PARAMETER),
        // double
        DOUBLE(ConstantsBase.DOUBLE_PARAMETER),
        // int
        INT(ConstantsBase.INTEGER_PARAMETER),
        // long
        LONG(ConstantsBase.LONG_PARAMETER);

        private String extended;

        private ParameterTypes(String extended) {
            this.extended = extended;
        }

        public String getExtended() {
            return extended;
        }
    }
}

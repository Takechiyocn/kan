package reflection.executeMethodFromDb;

/**
 *
 */
public class Enums {

    /**
     *
     */
    public enum ParameterTypes {
        //
        STRING("java.lang.String"),
        DOUBLE("double"),
        INT("int"),
        LONG("long");


        private String extended;

        private ParameterTypes(String extended) {
            this.extended = extended;
        }

        public String getExtended() {
            return extended;
        }
    }
}

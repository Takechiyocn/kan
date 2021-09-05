package generic;

import java.io.Serializable;

public class IntervalRawType implements Serializable {
    private Comparable lower;
    private Comparable upper;

    public IntervalRawType(Comparable first, Comparable second) {
        if (first.compareTo(second) <= 0) {
            this.lower = first;
            this.upper = second;
        } else {
            this.lower = second;
            this.upper = first;
        }
    }
}

package generic;

import java.time.LocalDate;


public class DateIntervalRawType extends PairRawType{

    // 擦除后的设置方法与父类的setSecond(Object)方法同时存在
    //
    public void setSecond(LocalDate second) {
        if (second.compareTo((LocalDate)this.getFirst()) >= 0) {
            super.setSecond(second);
        }
    }


}

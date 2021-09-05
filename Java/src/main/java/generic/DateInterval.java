package generic;

import java.time.LocalDate;

public class DateInterval extends Pair<LocalDate> {

    @Override
    public void setSecond(LocalDate second) {
        if (second.compareTo(getFirst()) >= 0) {
            super.setSecond(second);
        }
    }

    /**
     * 类型擦除后，该方法与父类方法签名一致getSecond()
     * 但虚拟机中，用参数类型和返回类型来确定一个方法，因此类型擦除后通过生成桥方法也能正常调用想定的方法
     * @return
     */
    @Override
    public LocalDate getSecond() {
        return super.getSecond();
    }

    public static void main(String[] args) {

        DateInterval interval = new DateInterval();
        // 子类型转父类型
        Pair<LocalDate> pair = interval;
        // 类型擦除后，pair引用DateInterval对象，所以应该调用DateInterval类的方法
        // 类型擦除引发多态，即Pair的setSecond(Object)与本类的setSecond(LocalDate)冲突
        //   因为是继承， 父类的setSecond方法本应与子类的setSecond方法一样(方法签名一致)
        //  --> 编译器在本类中生成一个桥方法(bridge method)
        //      @Override
        //      public void setSecond(Object second) { setSecond(Date) second };
        // 执行过程：
        //    1.父类只有一个setSecond(Object)方法
        //    2.pair引用为DateInterval类型，此时应调用子类重载的setSecond(Object)方法（桥方法）
        //    3.桥方法调用方法原始类型
        // 此处的setSecond(Object)和setSecond(LocalDate)方法被说成具有协变的返回类型(covariant return types)
        pair.setSecond(LocalDate.now());
    }
}

package test;

public class TemparatoryTest {

    public static void main(String[] args) {

        Boolean bl1 = true;
        System.out.println(bl1.hashCode());

        method1(bl1);
    }

    public static void method1(final Boolean bool) {
        System.out.println(bool.hashCode());
    }

}

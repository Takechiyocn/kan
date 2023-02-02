package test;

public class SampleTest {

    final int i = 1;
    int j;


    public void doSomething() {
        System.out.println(++j + i);
    }

    public static void main(String[] args) {
        SampleTest t = new SampleTest();
        t.doSomething();
    }
}

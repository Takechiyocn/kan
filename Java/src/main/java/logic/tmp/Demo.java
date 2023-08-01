package logic.tmp;

public class Demo {
    private String s = "成员变量";

    public void useDemo() {
        String s = "局部变量";
        System.out.println(this.s);
        System.out.println(s);
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        // 输出：
        //    成员变量
        //    局部变量
        demo.useDemo();
    }
}

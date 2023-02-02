## final关键字

1. final关键字可以用来修饰类(非抽象类，没有意义)、方法、变量

2. final修饰类：该类不可被继承

3. final修饰方法：该方法不能被重写
   
4. final修饰变量：final修饰的变量必须被初始化

    1. 修饰基本类型：值不能再改变
       
    2. 修饰引用类型：引用地址不可改变，引用的内容可以改变

## static关键字

1. static关键字可以用来修饰类(包含内部类)、方法、变量、代码块

2. static修饰类：静态类，可以不创建实例的情况下访问它的静态方法或静态成员

   ```java
   package NowCoder;
   class Test {
      public static void hello() {
         System.out.println("hello");
      }
   }
   public class MyApplication {
      public static void main(String[] args) {
      // TODO Auto-generated method stub
      Test test=null;
      // 输出hello，静态方法不依赖于于对象生存，只看类型
      test.hello();
      }
   }
   ```
   
3. static修饰方法：静态方法中不能用this，this随着对象创建而存在

   静态方法不能被重写

4. static修饰变量：属于类级别成员，而不属于单个对象，随着静态类的加载而创建




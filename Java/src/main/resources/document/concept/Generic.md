## 泛型

### 泛型类型变量<>赋值

1. 只看尖括号里边的！！明确点和范围两个概念
   
2. 点
   
    如果尖括号里的是一个类，那么尖括号里的就是一个点，比如List&lt;A>,List&lt;B>,List&lt;Object>
   
3. 范围
   
    如果尖括号里面带有问号，那么代表一个范围，&lt;? extends A> 代表小于等于A的范围，&lt;? super A>代表大于等于A的范围，<?>代表全部范围
   
4. 尖括号里的所有点之间互相赋值都是错，除非是俩相同的点

    ```java
    List<A> a;
    List<B> b;
    // 错误
    a = b; 
    ```
   
5. 尖括号小范围赋值给大范围，对，大范围赋值给小范围，错。如果某点包含在某个范围里，那么可以赋值，否则，不能赋值

    * 正确：
    
        * 点赋给相同的点
      
        * 点赋给范围(当点属于范围时)
          
        * 范围赋给范围(当小范围属于大范围时)
    
    * 错误：
    
        * 点赋给不同的点
      
        * 范围赋给点
   
6. List<?>和List是相等的，都代表最大范围
   
7. List既是点也是范围，当表示范围时，表示最大范围

    ```java
    class A {}
    class B extends A {}
    class C extends A {}
    class D extends B {}
    public static void main(String[] args) {
        List<A> a;
        List list;
        //正确：因为List就是List<?>，代表最大的范围，A只是其中的一个点，肯定被包含在内
        list = a;
        List<B> b;
        a = b;      //B错，点之间不能相互赋值
        List<?> qm;
        List<Object> o;
        qm = o;     //C对，List<?>代表最大的范围，List<Object>只是一个点，肯定被包含在内
        List<D> d;
        List<? extends B> downB;
        downB = d;  //D对，List<? extends B>代表小于等于B的范围，List<D>是一个点，在其中
        List<?extends A> downA;
        a = downA;  //E错，范围不能赋值给点
        a = o;      //F错，点之间不能赋值，List<Object>只是一个点
        downA = downB;  //G对，小于等于A的范围包含小于等于B的范围，因为B本来就比A小，B是A的子类嘛
    }
    ```
## Spring循环依赖

![img.png](images/LoopDependency.png)

* 循环依赖：自身依赖于自身、互相循环依赖、多组循环依赖

* 强依赖

    类在创建之初必须依赖于另一个对象，无法解决
    
    ```java
    public class LoopDependency {
        public static void main(String[] args) {
            new ClazzA();
        }
    }
    
    class ClazzA {
        private ClazzB b = new ClazzB();
    }
    
    class ClazzB {
        private ClazzA a = new ClazzA();
    }
    ```

### 循环依赖解决

1. Spring的get/set或者注解，进行一定程度的解耦(类的创建和属性的填充分离)

    * 先创建出半成品Bean
    
    * 填充属性，完成成品Bean
    
      ![LoopDependencyResolution.png](images/LoopDependencyResolution.png)

2. Spring内部解决循环依赖

    ![SpringLoopDependency.png](images/SpringLoopDependency.png)

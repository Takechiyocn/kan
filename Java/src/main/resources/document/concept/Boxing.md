## 装箱拆箱

包装器wrapper：基本类型都有一个与之对应的类。

基本数据类型|字节数|包装类|派生/继承于|包装类常量池
---|---|---|---|---
byte|1字节|Byte|Number|-128~127
short|2字节|Short|Number|-128~127
int|4字节|Integer|Number|-128~127
long|8字节|Long|Number|-128~127
float|4字节|Float|Number|无
double|8字节|Double|Number|无
char|2字节|Character|-|0~127
boolean|1字节|Boolean|-|无

* 自动装箱(autoboxing)
  
    将(类型)值直接添加到包装器实例中，内部进行类型自动转换的过程
  
    ```java
    ArrayList<Integer> list = new ArrayLst<>();
    // 自动转换成list.add(Integer.valueOf(3));
    list.add(3);
    ```

* 自动拆箱
  
    自动装箱的逆过程
  
    ```java
    // 自动转换成list.get(i).intValue();
    int n = list.get(i);
    // 自动装箱
    Integer n = 3;
    // 自动拆箱-->自加-->自动装箱
    n++;
    ```

1. 如果对象包装器类定义为final类型，亦即一旦构造了包装器对象，则不允许更改包装在其中的值    
   
2. 包装器类中有静态内部类IntegerCache，里面有个cache[]表示Integer常量池，即包装类可共用最大缓存对象值

    1. Byte/Short/Integer/Long：-128~127
     
    2. Float/Double没有常量池
       
    3. Character：0~127
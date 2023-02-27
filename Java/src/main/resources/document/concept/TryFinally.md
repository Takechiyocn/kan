## TryFinally

1. 如果只有try语句里面有return，代码行为如下：

    1. 将返回值保存到局部变量中，如return idx;
    
    2. 执行jsr指令跳转到finally语句里执行
    
    3. finally执行完毕后，返回之前保存在局部变量的值（finally修改idx对局部变量没有影响）
    
         ```java
         idx = 1;
         try {
             // 返回1
             return idx;
         } catch (Exception e) {
         }finally {
             // 对结果没有影响
             idx = 2;
         }
         ```
    
2. try和finally均有return，则忽略try的return，而使用finally的return。catch同理
   
   ```java
   idx = 1;
   try {
       // 被覆盖
       return idx;
   } catch (Exception e) {
   }finally {
       idx = 2;
       // 返回2
       return idx;
   }
   ```
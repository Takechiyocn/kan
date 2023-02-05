### 虚拟机异常


### OOM(Out Of Memory)

* java.lang.OutOfMemoryError: PermGen space

    * 场景：运行时常量池导致的溢出

    * 解决：设置-XX:MaxPermSize
    
* java.lang.OutOfMemoryError: Requested array size exceeds VM limit

    * 场景：创建一个超过虚拟机允许的大小的数组时出现
    
    * 原因：堆空间不足(较少见)

    * 解决：通过-Xmx增加堆的大小
    
* java.lang.OutOfMemoryError: Java heap space

    * 原因：堆内存问题

    * 解决：参考JVM.md中[堆溢出原因]
    
* java.lang.OutOfMemoryError: nativeGetNewTLA

    * 场景：只在jRockit虚拟机发生

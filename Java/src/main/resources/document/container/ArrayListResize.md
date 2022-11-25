## ArrayList扩容机制

1. 当使用add方法的时候首先调用 ensureCapacityInternal 方法，传入 size+1 进去，检查是否需要扩容

2. 如果空数组 DEFAULTCAPACITY_EMPTY_ELEMENTDATA ，就初始化为默认大小10，获取“默认的容量”和要扩容的大小两者之间的最大值

3. 和当前数组长度比较，如果 if (minCapacity - elementData.length > 0) 执行 grow 扩容方法

4. 将数组扩容为原来的1.5倍 int newCapacity = oldCapacity + (oldCapacity >> 1);

5. 检查新容量是否大于最小需要容量，若还是小于最小需要容量，那么就把最小需要容量当作数组的新容量

6. 再检查新容量newCapacity 是否超出了ArrayList所定义的最大容量，若超出了，则调用 hugeCapacity() 来比较minCapacity和 MAX_ARRAY_SIZE，如果minCapacity大于MAX_ARRAY_SIZE，则新容量则为Interger.MAX_VALUE，否则，新容量大小则为 MAX_ARRAY_SIZE（ MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8 ）

7. ArrayList 中copy数组的核心就是 System.arraycopy 方法，将original数组的所有数据复制到copy数组中，这是一个本地方法


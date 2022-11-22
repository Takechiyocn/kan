## 扩容死循环

```java
// JDK1.7
void resize(int newCapacity) {
    Entry[] oldTable = table;
    int oldCapacity = oldTable.length;
    //如果旧容量已经达到了最大，将阈值设置为最大值，与1.8相同
    if (oldCapacity == MAXIMUM_CAPACITY) {
    threshold = Integer.MAX_VALUE;
    return;
    }
    //创建新哈希表
    Entry[] newTable = new Entry[newCapacity];
    //将旧表的数据转移到新的哈希表
    //initHashSeedAsNeeded:判断是否需要重新计算hash值
    transfer(newTable, initHashSeedAsNeeded(newCapacity));
    //替换掉原“全局所有线程共享的table”，变成新的全局线程共享table
    table = newTable;
    //更新阈值
    threshold = (int) Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
}

void transfer(Entry[] newTable, boolean rehash) {
    int newCapacity = newTable.length;
    // 外层循环遍历数组槽（slot）
    for (Entry<K, V> e : table) {
        // 内层循环遍历单链表
        while (null != e) {
            // 记录当前节点的next节点
            Entry<K, V> next = e.next;
            if (rehash) {
                e.hash = null == e.key ? 0 : hash(e.key);
            }
            // 找到元素在新数组中的槽（slot）
            int i = indexFor(e.hash, newCapacity);
            // 用头插法将元素插入新的数组
            e.next = newTable[i];
            newTable[i] = e;
            // 遍历下一个节点
            e = next;
        }
    }
}
```

### 单线程

### 多线程


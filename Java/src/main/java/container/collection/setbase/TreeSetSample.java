package container.collection.setbase;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * 树集：可保存实现了Comparable接口的类对象
 *      也可保存在构造器中提供的Comparator对象(自定义Comparator比较器)
 *      -> 因为树集是有序的，所以需要比较器实现
 * @author moku
 */
public class TreeSetSample {

    public static void main(String[] args) {

        SortedSet<Item> parts = new TreeSet<>() {{
            add(new Item("Toaster2", 1234));
            add(new Item("Toaster1", 1234));
            add(new Item("Widget", 4562));
            add(new Item("Modem", 9912));
        }};
        // 重写SortedSet排序需要用到的compareTo方法，先按partNumber排序，再按description排序
        System.out.println(parts);

        // 自定义比较器Comparator的compare方法：按照description排序
        // 对象方法引用
        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription)
        );

        // 树集添加元素时，会将元素都被放置在树的正确位置上，即对元素进行排序然后确定树的位置
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}

class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return partNumber == item.partNumber && description.equals(item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(@NotNull Item o) {
        // TODO:此处重写TreeSet默认Comparable接口中的compareTo方法，如何确定先按partNumber排序，再按description排序
        int diff = Integer.compare(this.partNumber, o.partNumber);
        return diff != 0 ? diff : description.compareTo(o.description);
    }
}

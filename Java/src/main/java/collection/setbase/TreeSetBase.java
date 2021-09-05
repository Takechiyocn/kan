package collection.setbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 树集：有序集合sorted collection
 *      任意顺序插入元素，对集合进行遍历时，将会对值按照排序后的顺序出力
 *      添加元素比散列表慢，比数组或链表快
 *      查找新元素正确位置平均时长：log2n次比较，如一棵树包含1000个元素，添加新元素大约需要比较10次
 *
 * @author moku
 */
public class TreeSetBase {

    public static void main(String[] args) {

        SortedSet<String> sorter = new TreeSet<>() {{
            // 添加元素：每次添加的元素都被放置在树的正确位置上
            add("C");
            add("B");
            add("A");
            // 重复元素不添加
            add("C");
        }};
        // 排序后打印：排序用树结构完成（当前实现：红黑树red-black tree）
        System.out.println(sorter);

        long totalTime = 0;
        SortedSet<String> words = new TreeSet<>();
        try (Scanner in = new Scanner(new FileInputStream("src/main/resources/document/RandomWords.txt"))) {
            while (in.hasNext()) {
                String word = in.next();
                long localTime = System.currentTimeMillis();

                words.add(word);
                totalTime += System.currentTimeMillis() - localTime;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Words size:" + words.size() + ", Total time:" + totalTime + " milliseconds");

    }
}

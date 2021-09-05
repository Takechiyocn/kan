package collection.setbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 散列集HashSet：
 *    一个没有重复元素的无序集合,基于HashMap来实现，实际为HashMap实例
 * <p>
 * 散列码：散列表为每个对象计算一个整数，该整数称为散列码
 *
 * @author moku
 */
public class HashSetBase {

    public static void main(String[] args) {

        Set<String> words = new HashSet<>();
        long totalTime = 0;

        try (Scanner in = new Scanner(new FileInputStream("src/main/resources/document/RandomWords.txt"))) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                // 添加元素:HashSet.add()
                words.add(word);
                totalTime += System.currentTimeMillis() - callTime;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Iterator<String> iter = words.iterator();
        // 获取元素
        for (int i = 0; i < 3 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println("...");

        // 元素数量：HashSet.size()
        System.out.println("Words size:" + words.size() + ", Total time:" + totalTime + " milliseconds");

        // TODO：键的集聚
        hashSetBaeMethod();
    }

    private static void hashSetBaeMethod() {

        HashSet<String> sites = new HashSet<>() {{
            // 添加元素:重复元素不被添加
            add("Google");
            add("Runoob");
            add("Taobao");
            add("Zhihu");
            add("Runoob");
        }};

        // 获取元素数量
        int sitesCount = sites.size();
        System.out.println(sitesCount);

        // 获取元素: for-each
        for (String i : sites) {
            System.out.println(i);
        }

        // 删除元素：remove
        sites.remove("Google");
        System.out.println("After remove" + sites);

        // 删除所有元素：clear
        sites.clear();
        System.out.println("After clear" + sites);
    }
}

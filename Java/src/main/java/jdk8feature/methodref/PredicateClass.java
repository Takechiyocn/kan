package jdk8feature.methodref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * TODO: Predicate用法
 * @author moku
 */
public class PredicateClass {

   public static void main(String[] args) {

      List<String> str = new ArrayList<String>(Arrays.asList("a","b",null,"c"));

      System.out.println("Before remove, size:" + str.size());
      // 静态方法引用
      str.removeIf(Objects::isNull);
      System.out.println("After remove, size:" + str.size());
   }
}

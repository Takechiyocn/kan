package logic.professional.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @ClassName StreamBasic
 * @Description
 * @Author moku
 * @Date 2023/7/20 0:01
 * @Version 1.0
 */
public class StreamBasic {
    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> elements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.print(title + ": ");
        for (int i = 0; i < elements.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            if (i < SIZE) {
                System.out.print(elements.get(i));
            } else {
                System.out.print("...");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/logic/professional/stream/files/CountLongWords.txt");
//        var contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        var contents = Files.readString(path, StandardCharsets.UTF_8);

        // split into words:non numbers are delimiters
        // P: unicode属性
        // L: 字母 > "\\PL+"表示非字母作为分隔符
        // N: 数字
        List<String> words = List.of(contents.split("\\PL+"));

//        long count = 0;
//        for (String word : words) {
//            if (word.length() > 12) count++;
//        }
//        System.out.println(count);
//
//        count = words.stream().filter(word -> word.length() >12).count();
//        System.out.println(count);
//
//        count = words.parallelStream().filter(word -> word.length() >12).count();
//        System.out.println(count);

        // Stream.of:用数组构建具有任意数量引元的流
        Stream<String> wordStream = Stream.of(contents.split("\\PL+"));
        show("words", wordStream);
        Stream<String> song = Stream.of("song", "artist", "album");
        show("song", song);


        // Array.stream:用数组中的一部分元素来创建流
        String[] array = new String[]{"song", "artist", "album"};
        Stream<String> arrayStream = Arrays.stream(array, 0, array.length - 1);

        // Stream.empty:创建不包含任何元素的流
        Stream<String> silence = Stream.empty();

        // Stream.generate:创建无限流
        // 不接受任何引元，只需要一个流类型的值，generate函数被调用以产生这样一个值
        // 常量值无限流
        Stream<String> echos = Stream.generate(() -> "Echos");
        show("echos", echos);
        // 随机数无限流
        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);

        // 随机数流序列0,1,2,3,4,5,6,7,8,9..
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        show("integer", integers);
        // 有限序列
        var limit = new BigInteger("1000000");
        Stream<BigInteger> limitIntegers = Stream.iterate(BigInteger.ZERO, n -> n.compareTo(limit) < 0, n -> n.add(BigInteger.ONE));
        show("limitIntegers", limitIntegers);

        // TODO:Stream.ofNullable:使用对象创建流
        // 如果对象为null，流长度为0；否则流长度为1，即只包含该对象

        // Pattern类产生流
        Stream<String> wordsByPattern = Pattern.compile("\\PL+").splitAsStream(contents);
        show("wordsByPattern", wordsByPattern);

        // Files.lines:返回文件中所有行的流
        Stream<String> lines = Files.lines(path,StandardCharsets.UTF_8);
        show("lines", lines);

        // 持有的Iterable对象不是集合时，StreamSupport.stream将其转换为流
        Iterable<Path> iterable = FileSystems.getDefault().getRootDirectories();
        Stream<Path> rootDirectories = StreamSupport.stream(iterable.spliterator(),false);
        show("rootDirectories", rootDirectories);

        // 持有的是Iterator对象时，并希望获取一个由它构成的流
        Iterator<Path> iterator = Paths.get("src/main/java/logic/professional/stream/files/CountLongWords.txt").iterator();
        Stream<Path> pathComponents = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED),false);
        show("pathComponents", pathComponents);

    }
}

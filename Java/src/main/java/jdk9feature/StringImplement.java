package jdk9feature;

/**
 * @author moku
 */
public class StringImplement {
    public static void main(String[] args) {

        // String底层由Char[]变为Byte[]实现
        // 优化空间->减少触发GC的次数->减少Stop the world activity的次数->提高系统性能
        // 1. char类型的数据在jvm中占用了两个字节的空间，使用的是UTF-16编码
        // 2. 优化为byte[]，并提供了另外一种编码可能性。
        //    a. Latin-1编码是用单个字节来表示字符，比两个字节的utf-16节省了一半空间
        //    b. String类中多了一个编码标志位coder，用来表示使用的是utf-16编码，还是Latin-1编码
        //    c. java会根据字符串的内容自动设置相应的编码，要么UTF16，要么LATIN1
    }
}

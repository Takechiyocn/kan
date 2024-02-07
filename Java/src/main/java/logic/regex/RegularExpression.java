package logic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegularExpression
 * @Description
 * @Author moku
 * @Date 2023/2/1 19:22
 * @Version 1.0
 */
public class RegularExpression {

    public static void main(String[] args) {
        // 1. 用于匹配
        RegexMatch();

        // 2. 用于替换
        RegexReplace();

        // 3. 用于切割
        RegexSplit();
    }

    private static void RegexMatch() {
        // 1. 匹配一个数字
        String str = "8";
        String regex = "[0-9]";
        boolean flag = Pattern.matches(regex, str);
        System.out.println("匹配一个数字：" + flag);

        // 2. 匹配3个到5个字母，大小写不限，包括3个和5个
        String str2 = "Hello";
        String regex2 = "[a-zA-Z]{3,5}";
        System.out.println("匹配3个到5个字母，大小写不限，包括3个和5个:" + str2.matches(regex2));
        System.out.println("匹配3个到5个字母，大小写不限，包括3个和5个:" + "He".matches(regex2));

        // 3. 匹配11位电话号码，规则：
        //    第一个是数字是1
        //    第二个是数字是2、3、7、8中任意一个
        //    后面9位数字不包含4
        String str3 = "13656231253";
        String regex3 = "1[2378][0-35-9]{9}";
        // 将给定的正则表达式编译为模式
        // 如果匹配需求较多，且需用相同的regex去匹配，就可将这句写到静态模块里面，需要时直接使用实例p
        Pattern p = Pattern.compile(regex3);
        // 创建一个匹配器，匹配给定的输入与此模式
        Matcher m = p.matcher(str3);
        // 尝试将整个区域与模式进行匹配
        boolean flag3 = m.matches();
        System.out.println("匹配11位电话号码:" + flag3);
    }

    private static void RegexReplace() {
        String str = "12a6B985Ccv65";
        String regex = "[a-zA-Z]+";
        // \d表示数字，此处\\内第一个\为转义字符用
        String regex2 = "\\d+";
        // 将字符串内应为字母替换为&符号
        System.out.println(str.replaceAll(regex, "&"));
        // 将字符串内单个数字或者连续的数字替换为0
        System.out.println(str.replaceAll(regex2, "0"));
    }

    private static void RegexSplit() {
        String str = "oneTtowTthreeDfourJfive";
        String regex = "[A-Z]";
        // 根据大写字母切割字符串
        String[] arr = str.split(regex);
        for (String s : arr) {
            System.out.print(s + " ");
        }

        String str2 = "boo:and:foo";
        // 单个匹配的字符o为单位进行分割
        String regex2 = "[o]";
        String[] arr2 = str2.split(regex2);
        for (String s : arr) {
            System.out.print(s + " ");
        }

        String str3 = "boo:and:foo";
        // 单个或连续匹配的字符o为单位进行分割
        String regex3 = "[o]+";
        String[] arr3 = str2.split(regex3);
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}

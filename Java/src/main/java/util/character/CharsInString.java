package util.character;

import constant.Constants;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 取字符串中各个字符的个数
 *
 * @author moku
 * @date 2023/2/1 15:06:25
 * @version 1.0
 */
public class CharsInString {


    public static void main(String[] args) {

        try {
//            String inputPath = args[0];
//            String outputPath = args[1];

            // 控制台作为输入流
            Scanner sc = new Scanner(System.in);
            // 指定文件路径作为输入流
//            Scanner sc = new Scanner(new FileReader(inputPath));
            // 指定文件路径作为输出流
//            PrintStream ps = new PrintStream(outputPath);
            // 获取输入的字符串
            String s = sc.nextLine();
            // 调用方法并输出结果
//            ps.println(solution.getLettersCounts(s));
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(getLettersCounts(s)));

//            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提取字符串中各类字符个数
     * @param s
     * @return java.util.Map<java.lang.String,java.lang.Integer>
     */
    public static Map<String, Integer> getLettersCounts(@NotNull String s) {

        int nums = 0;//数字
        int letters = 0;//字母
        int spaces = 0;//空格
        int others = 0;//其他

        Map<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= 48 && c <= 57) {
                // 字符c为数字
                map.put("Numbers", ++nums);
            } else if (c == 32) {
                // 字符c为空格
                map.put("Spaces", ++spaces);
            } else if (c >= 65 && c <= 90 || c >= 97 && c <= 122) {
                // 字符c为字母 65~99为大写字母 97~122为小写字母
                map.put("Letters", ++letters);
            } else {
                map.put("Others", ++others);
            }
        }
        return map;
    }

    /**
     * 字符串内各个字符是否全部为字母
     * @param s
     * @return boolean
     */
    public static boolean allCharsInAlphabet(String s) {
        return s.chars().allMatch(c -> Constants.PATTERN_ALPHABET.matcher(String.valueOf((char)c)).find());
    }

    /**
     * 字符串内各个字符是否全部为英数字
     * @param s
     * @return boolean
     */
    public static boolean allCharsInAlphabetNumber(String s) {
        return s.chars().allMatch(c -> Constants.PATTERN_ALPHABET_NUMBER.matcher(String.valueOf((char)c)).find());
    }

    /**
     * 字符串内各个字符是否全部包含在指定字符串内 -> 方法2：使用obj.toCharArray，再对字符数组内每个字符进行判断
     * @param source
     * @param obj
     * @return boolean
     */
    public static boolean allCharsInString(String source, String obj) {
        return obj.chars().allMatch(c -> source.contains(String.valueOf((char)c)));
    }

    /**
     * 字符串内各个字符是否全部包含在指定字符串内
     * @param source
     * @param obj
     * @return boolean
     */
    public static boolean allCharsInString2(@NotNull String source, @NotNull String obj) {
        char[] chars = obj.toCharArray();

        for (char c : chars) {
            if (!source.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }
}


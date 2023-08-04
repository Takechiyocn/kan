package util.scene;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName CharsInString
 * @Description 提取字符串中各个字符的个数
 * @Author moku
 * @Date 2023/2/1 15:06
 * @Version 1.0
 */
public class CharsInString {
    public static void main(String[] args) {

        try {
            String inputPath = args[0];
            String outputPath = args[1];

            Scanner sc = new Scanner(new FileReader(inputPath));
            PrintStream ps = new PrintStream(outputPath);
            // 获取输入的字符串
            String s = sc.nextLine();
            Solution solution = new Solution();
            // 调用方法并输出结果
            ps.println(solution.getLettersCounts(s));

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Solution {
    public Map<String, Integer> getLettersCounts(String s) {

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
}
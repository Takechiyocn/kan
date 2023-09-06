package util.character;

/**
 * 统计字符串中指定字符(串)出现的次数
 *
 * @author moku
 * @date 2023/8/25 16:59:07
 * @version 1.0
 */
public class CharactersInString {

    public static void main(String[] args) {
        System.out.println("Starting： " + countCharactersInString("abcdefghijklmnopqrstuvwd", "d"));
        System.out.println("Starting： " + countCharactersInString("abcdefghijklmnopqrstuvw", "de"));

        System.out.println("Starting： " + countCharactersInString2("abcdefghijklmnopqrstuvwd", "d"));
        System.out.println("Starting： " + countCharactersInString2("abcdefghijklmnopqrstuvw", "de"));
    }

    /**
     * 统计指定字符(串)出现次数
     * @param s
     * @param obj
     * @return int
     */
    public static int countCharactersInString(String s, String obj) {

        int count = 0;
        int index = 0;
        while (s.indexOf(obj, index) >= 0) {
            count++;
            index = s.indexOf(obj, index) + obj.length();
        }
        return count;
    }

    /**
     * 统计指定字符(串)出现次数
     * @param s
     * @param obj
     * @return int
     */
    public static int countCharactersInString2(String s, String obj) {
        return (s.length() - s.replaceAll(obj, "").length()) / obj.length();
    }
}

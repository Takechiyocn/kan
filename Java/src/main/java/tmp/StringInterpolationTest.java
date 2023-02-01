package tmp;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName StringInterpolationTest
 * @Description
 * @Author moku
 * @Date 2023/1/12 15:22
 * @Version 1.0
 */
public class StringInterpolationTest {

    public String stringInterpolation(String content, String values) {
        boolean valueExist = false;
        StringBuilder result = new StringBuilder();
        Gson gson = new Gson();

        // 转换values为Map对象
        Map<String, String> resultMap = new HashMap<>();
        resultMap = gson.fromJson(values, resultMap.getClass());

        // 获取content待替换字符串
        List<String> contentAttribute = new ArrayList<>();
        contentAttribute = subString(content);

        // 获取content待替换前字符串
        int leftCurlBraceFirstIndex = content.indexOf("{{");
        int rightCurlBraceFirstIndex = content.indexOf("}}");
        int leftCurlBraceSecondIndex = content.indexOf("{{", leftCurlBraceFirstIndex + 1);
        int rightCurlBraceSecondIndex = content.indexOf("}}", rightCurlBraceFirstIndex + 1);
        String contentSub = content.substring(0, leftCurlBraceFirstIndex);
        String contentSub2 = content.substring(rightCurlBraceFirstIndex + 2, leftCurlBraceSecondIndex);
        String contentSub3 = content.substring(rightCurlBraceSecondIndex + 2);
        result.append(contentSub);

        // values键值对计数
        int cnt = 0;
        for (int i = 0; i < contentAttribute.size(); i++) {
            for (Map.Entry<String, String> entry : resultMap.entrySet()) {
                String k = entry.getKey();
                String v = String.valueOf(entry.getValue());
                if (contentAttribute.get(i).equals(k.toUpperCase())) {
                    result.append(v);
                    if (i == 0) {
                        result.append(contentSub2);
                    } else if (i == 1) {
                        result.append(contentSub3);
                    }
                    cnt++;
                }
            }
        }

        // 键值对不完整
        if (cnt != 2) {
            StringInterpolationException e = new StringInterpolationException("Value missed.");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return result.toString();
    }

    /**
     * 获取content待替换关键字
     *
     * @Params:[s]
     * @Returns:java.util.List<java.lang.String>
     */
    public List<String> subString(String s) {
        List<String> results = new ArrayList<String>();
        Pattern p = Pattern.compile("^.*[\\{\\{\\}\\}].*$");
        Matcher m = p.matcher(s);
        while (m.find()) {
            results.add(m.group(0));
        }
        return results;
    }

    public static void main(String[] args) {

        StringInterpolationTest stringInterpolationTest = new StringInterpolationTest();

        System.out.println(stringInterpolationTest.stringInterpolation("A {{ name }} B {{ age }}.",
                "{name: Bill, age: 21 }"));
    }
}

class StringInterpolationException extends Exception{
    public StringInterpolationException() {
    }

    public StringInterpolationException(String message) {
        super(message);
    }
}

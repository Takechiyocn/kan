package deploy;

import java.io.*;
import java.util.Properties;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

/**
 * 配置用户信息：
 *   1. 属性映射：Properties ->没有层次结构
 *   2. 首选项API：Preferences ->树状结构存储库（通常写到注册表）
 */
public class ConfigurationStore {

    public static void main(String[] args) throws IOException, BackingStoreException, InvalidPreferencesFormatException {

        // 1. 属性映射：Properties
        propertiesSetting();

        // 首选项API：Preferences
        preferencesSetting();

    }

    private static void preferencesSetting() throws IOException, BackingStoreException, InvalidPreferencesFormatException {
        // 从用户或系统根节点开始访问树中的子节点
        Preferences root = Preferences.userRoot();
        Preferences root2 = Preferences.systemRoot();

        // 访问树中的子节点:利用根节点
        Preferences node = root.node("/src/main/java");
        // 设置配置信息
        node.putInt("left", 100);
        node.putInt("top", 200);
        node.putInt("width", 300);
        node.putInt("height", 400);
        node.put("title", "myPreferences");

        // 保存配置信息到xml文件
        String property = "preferences.properties.xml";
        OutputStream out = new FileOutputStream(property);
        // 将这个节点及其子节点的首选项写至指定的流
        node.exportSubtree(out);
        // 将这个节点（不包含其子节点）的首选项写至指定的流
//        node.exportNode(out);
        out.close();

        // 获取配置信息
        System.out.println(node.getInt("top",0));
        System.out.println(node.get("title1","default value"));

        // 导入指定配置文件到系统？
        InputStream in = new FileInputStream(property);
        Preferences.importPreferences(in);
        in.close();
        Preferences node2 = root.node("/src/main/java");
        System.out.println(node2.getInt("top",0));

        // 访问树中的子节点:利用类对象
//        Employee el = new Employee("el1");
//        Preferences node2 = Preferences.userNodeForPackage(el.getClass());
//        Preferences node3 = Preferences.systemNodeForPackage(el.getClass());
    }

    private static void propertiesSetting() throws IOException {
        // 属性映射property map
        Properties settings = new Properties();
        // 设置属性
        settings.setProperty("width", "200");
        settings.setProperty("title", "Hello World!");
        // 属性查找：查找属性时指定默认值，当键值不存在时返回该默认值
        String author = settings.getProperty("author", "moku");
        System.out.println(author);

        // 保存属性映射列表到文件
        String propertyFile = "program.properties";
        OutputStream out = new FileOutputStream(propertyFile);
        settings.store(out, "Program Properties");

        // 加载属性
        File file;
        InputStream in = new FileInputStream(propertyFile);
        Properties settings2= new Properties();
        settings2.load(in);
        System.out.println(settings2);

        // 用户主目录
        System.out.println(System.getProperty("user.home"));
    }
}

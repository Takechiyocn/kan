## Scanner

扫描器，用于获取用户输入

解析基本字符，解析字符串

### 基本语法


#### 读取用户输入

```java
Scanner s = new Scanner(System.in);
```

* next()

    * 过滤掉空白输入，直到读取到有效字符
    
    * 结束输入：
    
        * 读取到有效字符后的空白字符
    
        * 结束符(换行符\n、回车换行符(\r\n)或者Enter键)

* nextLine()
  
    * 读取一行输入

    * 结束输入：

        * 结束符(Enter键)

#### 读取路径

```java
Scanner in = new Scanner(Paths.get("src/main/java/util/file/test.txt"), "UTF-8");
while (in.hasNextLine()) {
    System.out.println("读取文件(Paths.get)：" + in.nextLine());
}
in.close();
```

#### 读取输入流InputStream

同System.in

```java
// System.in定义
public static final InputStream in = null;

// 带资源的try语句
try (Scanner in = new Scanner(new FileInputStream("src/main/java/util/file/test.txt"))) {
    while (in.hasNextLine()) {
        System.out.println("读取文件(FileInputStream)：" + in.nextLine());
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
```

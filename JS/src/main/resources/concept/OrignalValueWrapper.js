function originalValueWrapper() {
    // 使用new调用原始值包装类型的构造函数，与调用同名的转型函数产生的类型不一致
    let value = "25";
    let number = Number(value);       // 转型函数
    console.log(typeof number);     // number
    let obj = new Number(value);      // 原始包装类型
    console.log(typeof obj);        // object

    // 所有原始值包装对象都会转换为布尔值true(在布尔表达式中会转换)
    let falseObject = new Boolean(false);       // false
    let result = falseObject && true;                  // true：布尔表达式
    console.log("Primitive type boolean(Boolean object):" + result);

    // String函数
    // concat
    let str1 = "Hello ";
    let str2 = "World";
    console.log(str1.concat(str2, "!"));
    console.log(str1);
    console.log(str2);
    // slice,substring: 长度parameter2-parameter1
    //   parameter1: 字符串开始位置
    //   parameter2：字符串结束位置(不包含)
    // substr
    //   parameter1: 字符串开始位置
    //   parameter2：提取字符串数量
    let str3 = "Hello world";
    console.log(str3.slice(3));         // lo world
    console.log(str3.substring(3));     // lo world
    console.log(str3.substr(3));    // lo world
    console.log(str3.slice(3, 7));           // lo w
    console.log(str3.substring(3, 7));       // lo w
    console.log(str3.substr(3, 7));  // lo worl
    // 参数为负数时
    // slice: 所有负参数当成(转换为)字符串长度加上负参数值
    console.log("negative:"+str3.slice(-3));        // rld
    console.log(str3.slice(3, -4));        // lo w
    // substring: 所有负参数都转化为0
    console.log(str3.substring(-3));    // hello world
    console.log(str3.substring(3, -4));    // hel   --> str3.substring(3,0) --> str3.substring(0,3) 会将较小的值作为起点
    // substr:
    //   第一个负参数当成(转换为)字符串长度加上负参数值
    //   第二个负参数当成(转换为)0
    console.log(str3.substr(-3));   // rld
    console.log(str3.substr(3,-4)); // ""  空字符串

    // indexOf: 从前往后搜索
    // lastIndexOf:从后往前搜索
    //   未找到，返回-1
    //   若设置第二个参数：则从第二个参数指定位置开始搜索
    console.log("first:"+str3.indexOf("o") + ",last"+str3.lastIndexOf("o")); // 4, 7
    console.log("first:"+str3.indexOf("o",6) + ",last"+str3.lastIndexOf("o",6)); // 7, 4

    // 字符串包含
    // startsWith,endsWith,includes
    let str4 = "foobarbaz";
    console.log(str4.startsWith("foo"));    // true
    console.log(str4.startsWith("bar"));    // false
    console.log(str4.endsWith("baz"));      // true
    console.log(str4.endsWith("bar"));      // false
    console.log(str4.includes("bar"));      // true
    console.log(str4.includes("bax"));      // false
    // 第二个参数
    //   startsWith，includes：开始搜索位置
    console.log("Seconde parameters:"+str4.startsWith("foo"));    // true
    console.log(str4.startsWith("foo",1));    // false
    console.log(str4.includes("bar"));    // true
    console.log(str4.includes("bar", 4));    // false

    //   endsWith：假定(当作)字符串总长度（假定字符串只有指定长度字符）
    console.log(str4.endsWith("bar"));      // false
    console.log(str4.endsWith("bar",6));    // true

    // 删除前后所有空格符
    // trim：原始字符串不受影响
    let str5 = "  hello world  !";
    let str6 = str5.trim();
    console.log(str5);
    console.log(str6);

    // repeat：字符串复制
    console.log("ha".repeat(2));
}
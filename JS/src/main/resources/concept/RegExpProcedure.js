function regExpNormal() {
    // 1. 字面量第一正则表达式
    // let expression = /pattern/flags;
    // flags:
    //   g:全局模式，查找字符串全部内容global
    let pattern1 = /at/gi;   // 匹配字符串中所有"at"

    //   i:不区分大小写ignoreCase
    let pattern2 = /[bc]at/i;       // 匹配第一个bat或cat，忽略大小写
    // 捕获组：bat，cat
    let pattern21 = /\[bc\]at/i;    // 匹配第一个[bc]at，或略大小写
    let pattern3 = /.at/gi;         // 匹配所有以at结尾的三字符组合，忽略大小写
    let pattern31 = /\.at/gi;       // 匹配所有.at，忽略大小写
    //   m:多行模式，查找到一行文本末尾时会继续查找multiline
    //   y:粘附模式，只查找从lastIndex开始之后的字符串sticky
    let pattern4 = /.at/y;          //
    //   u:Unicode模式，启用Unicode匹配unicode
    //   s:dotAll模式，表示元字符.匹配任何字符（包括\r\n）
    //   --> 元字符在模式中需要转义
    //        ( [ { \ ^ $ | } ] ) ? * + .
    // lastIndex:整数，表示在源字符串中下一次搜索开始的位置，始终从0开始
    // 2. RegExp函数构建正则表达式
    //    --> 元字符需要二次转义
    let pattern1_1 = new RegExp("at","g");
    let pattern2_1 = new RegExp("[bc]at","i");
    let pattern21_1 = new RegExp("\\[bc\\]at","i");
    let pattern3_1 = new RegExp(".at","gi");
    let pattern31_1 = new RegExp("\\.at","gi");

    // exec
    //  index:字符串中匹配模式的起始位置
    //  input:要查找的字符串
    let text = "cat, bat, sat, fat";
    let text2 = "cat, bat, sat, fat";
    let text21 = "cat, bat, sat, fat";
    let text3 = "cat, bat, sat, fat";
    let text31 = "cat, bat, sat, fat";
    let text4 = "cat, bat, sat, fat";
    console.log(pattern1.exec(text));   // at
    console.log(pattern2.exec(text2));  // cat
    console.log(pattern21.exec(text21));    // null
    // 由于设置了全局搜索，每次调用会匹配一次字符串
    console.log(pattern3_1.exec(text3));  // cat
    console.log(pattern3_1.exec(text3));  // bat
    console.log(pattern3_1.exec(text3));  // sat
    console.log(pattern3_1.exec(text3));  // fat
    console.log(pattern31.exec(text31));    // null

    // 第一次查找之后lastIndex=3, text[3]="," 无法匹配故返回null
    console.log(pattern4.exec(text4));  // cat
    console.log(pattern4.exec(text4));  // null

    let textx="mom and dad and baby";
    let patternx = /mom( and dad( and baby)?)?/gi;
    let matchesx = patternx.exec(textx);
    console.log(matchesx.index);     // 0
    console.log(matchesx.input);     // text变量即mom and dad and baby
    // matches[0]: mom and dad and baby
    // matches[1]: and dad and baby
    // matches[2]: and baby

    // test()方法
    let zipCode="000-00-0000";
    let zipPattern=/\d{3}-\d{2}-\d{4}/;
    if (zipPattern.test(zipCode)) {
        console.log("Matched!")
    }

    // RegExp构造函数
    // RegExp构造函数的所有属性没有web标准出处，不要在生产环境中使用
    let regExpConstructor = "this has been a short summer";
    let constructorPattern = /(.)hort/g;
    if (constructorPattern.test(regExpConstructor)) {
        console.log(RegExp.input);  // 最后搜索的字符串，regExpConstructor
        // 简写形式
        console.log(RegExp.$_);  // 最后搜索的字符串，regExpConstructor
        console.log(RegExp.lastMatch);  // 最后匹配的文本，short
        console.log(RegExp.lastParen);  // 最后匹配的捕获组，s 非标准属性
        // 简写形式
        console.log(RegExp["$+"]);
        console.log(RegExp.leftContext);    // input字符串中出现在lastMatch前的文本，this has benn a ，非标准属性
        console.log(RegExp.rightContext);   // input字符串中出现在lastMatch后的文本，summer 非标准属性
    }

    // RegExp可以存储最多9个捕获组的匹配项，可通过RegExp.$1~RegExp$.9访问
    let regExpConstructorMax = "this has been a short summer";
    let constructorPatternMax = /(..)or(.)/g;
    if(constructorPatternMax.test(regExpConstructorMax)) {
        console.log(RegExp.$1);     // sh
        console.log(RegExp.$2);     // t
    }



}
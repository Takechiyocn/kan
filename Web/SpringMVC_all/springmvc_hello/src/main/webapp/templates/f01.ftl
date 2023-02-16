<#--
    html 注释语法
        浏览器中查看源码可见

-->
<#--
    freemarker 注释语法
        浏览器中查看源码可见（开发中推荐使用）
        1.在freemarker中，html所有标签均适用
        2.js、css均适用，语法一致
-->
<#--接收数据-->
${msg}<br>
<br>
<#--
    数据类型：布尔类型
        在freemarker中布尔类型不能直接输出；如果输出要先转成字符串
        方式一：?c
        方式二：?string 或 ?string("true时的文本","false时的文本")
-->
${flag?c}<br>
${flag?string}<br>
${flag?string("yes","no")}<br>
<br>
<#--
    数据类型：日期类型
        在freemarker中日期类型不能直接输出；如果输出要先转成日期型或字符串
        1. 年月日 ?date
        2. 时分秒 ?time
        3. 年月日时分秒 ?datetime
        4. 指定格式 ?string("自定义格式")
            y：年 M：月 d：日
            H：时 m：分 s：秒
-->
<#-- 输出日期格式 -->
${createDate?date} <br>
<#-- 输出时间格式 -->
${createDate?time} <br>
<#-- 输出日期时间格式 -->
${createDate?datetime} <br>
<#-- 输出格式化日期格式 -->
${createDate?string("yyyy年MM月dd日 HH:mm:ss")} <br>
<br>

<#--
    数据类型：数值类型
        在freemarker中数值类型可以直接输出；
        1. 转字符串
            普通字符串 ?c
            货币型字符串 ?string.currency
            百分比型字符串 ?string.percent
        2. 保留浮点型数值指定小数位（#表示一个小数位）
            ?string["0.##"]
-->
<#-- 直接输出数值型 -->
${age} <br>
${salary} <br>
<#-- 将数值转换成字符串输出 -->
${salary?c} <br>
<#-- 将数值转换成货币类型的字符串输出 -->
${salary?string.currency} <br>
<#-- 将数值转换成百分比类型的字符串输出 -->
${avg?string.percent} <br>
<#-- 将浮点型数值保留指定小数位输出 （##表示保留两位小数） -->
${avg?string["0.##"]} <br>
<br>

<#--
    数据类型：字符串类型
        在freemarker中字符串类型可以直接输出；
        1. 截取字符串（左闭右开） ?substring(start,end)
        2. 首字母小写输出 ?uncap_first
        3. 首字母大写输出 ?cap_first
        4. 字母转小写输出 ?lower_case
        5. 字母转大写输出 ?upper_case
        6. 获取字符串长度 ?length
        7. 是否以指定字符开头（boolean类型） ?starts_with("xx")?string
        8. 是否以指定字符结尾（boolean类型） ?ends_with("xx")?string
        9. 获取指定字符的索引 ?index_of("xx")
        10. 去除字符串前后空格 ?trim
        11. 替换指定字符串 ?replace("xx","xx")
-->
<#-- 直接输出 -->
${msg1} - ${msg2} <br>
${msg1?string} - ${msg2?string} <br>
<#-- 1. 截取字符串（左闭右开） ?substring(start,end) -->
${msg2?substring(1,4)} <br>
<#-- 2. 首字母小写输出 ?uncap_first -->
${msg1?uncap_first} <br>
<#-- 3. 首字母大写输出 ?cap_first -->
${msg2?cap_first} <br>
<#-- 4. 字母转小写输出 ?lower_case -->
${msg1?lower_case} <br>
<#-- 5. 字母转大写输出 ?upper_case -->
${msg1?upper_case} <br>
<#-- 6. 获取字符串长度 ?length -->
${msg1?length} <br>
<#-- 7. 是否以指定字符开头（boolean类型） ?starts_with("xx")?string -->
${msg1?starts_with("H")?string} <br>
<#-- 8. 是否以指定字符结尾（boolean类型） ?ends_with("xx")?string -->
${msg1?ends_with("h")?string} <br>
<#-- 9. 获取指定字符的索引 ?index_of("xxx") -->
${msg1?index_of("e")} <br>
<#-- 10. 去除字符串前后空格 ?trim -->
${msg1?trim?length} <br>
<#-- 11. 替换指定字符串 ?replace("xx","xxx") -->
${msg1?replace("o","a")}<br>
<br>


<#-- 如果值不存在，直接输出会报错 -->
<#--${str}-->
<#-- 使用!，当值不存在时，默认显示空字符串 -->
${str!}<br>
<#-- 使用!"xx"，当值不存在时，默认显示指定字符串 -->
${str!"这是一个默认值"}<br>
<#-- 使用??，判断字符串是否为空；返回布尔类型。如果想要输出，需要将布尔类型转换成字符串 -->
${(str??)?string}<br>

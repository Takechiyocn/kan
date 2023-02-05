## JDBC接口

### 构建样例

* Statement

```sql
// 不带参数所以不用传入SQL语句
Statement sta=con.createStatement();
ResultSet rst=sta.executeQuery("select * from book");
```

* PreparedStatement

```sql
// 需要传入SQL语句(因为可变参数)
PreparedStatement pst=con.prepareStatement("select * from book");
ResultSet rst=pst.executeQuery();
```

### 区别

区别|Statement|PreparedStatement|CallableStatement
---|---|---|---
继承|Wrapper|Statement|PreparedStatement
方法|提供执行语句和获取结果的基本方法|添加处理IN参数的方法|添加处理OUT参数的方法
功能|1.普通的不带参的查询SQL|1.可变参数的SQL,编译一次执行多次，效率高|1. 支持带参的SQL操作
功能|2.支持批量更新、批量删除|2.安全性好，有效防止SQL注入等问题|2.支持调用存储过程，提供对输入/输出参数的支持
功能|-|3.支持批量更新、批量删除|-
特点|每次执行SQL，数据库都要执行SQL的编译|预编译，优点：|
用途|用于仅执行一次查询并返回结果的情形，此时效率高于PreparedStatement||

PreparedStatement优点

* 执行可变参数的一条SQL时，PreparedStatement比Statement效率高看，因为DBMS预编译VS多次编译

* 安全性好，有效防止SQL注入等问题

    * 传入SQL后，执行语句前给参数赋值，避免拼接SQL带来的安全问题

* 对于多次重复执行的语句，PreparedStatement效率更高，这种情况也比较适合使用batch

* 代码可读性和可维护性


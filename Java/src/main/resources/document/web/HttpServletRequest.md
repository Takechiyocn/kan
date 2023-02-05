## HttpServletRequest方法

* Cookie[] getCookies()

  返回一个数组，包含客户端发送该请求的所有的Cookie对象

* Object getAttribute(String name)
    
    以对象形式返回已命名属性的值，如果没有给定名称的属性存在，则返回null
  
* String getHeader(String name)

    以字符串形式返回指定的请求头的值。Cookie也是头的一种

* String getParameter(String name)

    以字符串形式返回请求参数的值，或者如果参数不存在则返回null
  
## ServletContext相关方法

* getParameter()：获取POST/GET传递的参数值
  
* getInitParameter()：获取Tomcat的server.xml中设置Context的初始化参数
  
* getAttribute()：获取对象容器中的数据值
  
* getRequestDispatcher()：请求转发

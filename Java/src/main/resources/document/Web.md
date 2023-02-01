## Session和Cookie

1. session用来表示用户会话，session对象在服务端维护，一般tomcat设定session生命周期为30分钟，
   超时将失效，也可以主动设置为无效
   
2. 服务器设置的cookie存放在客户端，可以分为内存cookie和磁盘cookie。
   内存cookie在浏览器关闭后消失，磁盘cookie超时后消失。
   当浏览器发送请求时，将自动发送对应cookie信息，前提是请求url满足cookie路径
   
3. 大部分session机制都使用cookie来保存sessionId，也可以通过重写url将sessionId拼接在url，
   因此可以通过查看浏览器cookie或地址栏url看到sessionId
   
4. 请求到服务端时，将根据请求中的sessionId查找session，如果可以获取到则返回，
   否则返回null或者返回新构建的session，旧的session依旧存在
   
5. 浏览器关闭时，如果cookie保存在磁盘或改写HTTP请求报头(sessionId)，依然能找到原来的session
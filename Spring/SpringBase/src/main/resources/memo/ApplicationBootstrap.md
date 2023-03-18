## application.yml和bootstrap.yml区别

* bootstrap.yml文件是SpringBoot的默认配置文件，而且其加载时间相比于application.yml更早。
* bootstrap.yml和application.yml都是默认配置文件，但定位不同
* bootstrap.yml可以理解成系统级别的一些参数配置，一般不会变动
* application.yml用来定义应用级别的参数
* 搭配spring-cloud-config使用application.yml的配置可以动态替换。
* bootstrap.yml相当于项目启动的引导文件，内容相对固定
* application.yml文件是微服务的常规配置参数，变化比较频繁

### 清单文件manifest

```manifest
版本号
Manifest-Version: 1.0

密封:改变全局默认设定
Saled: true

指定应用程序主类
Main-Class: resource.ResourceTest

打包工具
Created-By: 16.0.1 (Oracle Corporation)

描述归档文件的行
Name:Woozle.class
Saled: false

描述包的行
Name:com/company/mypkg
Saled: true

打包清单文件
jar cfm JarFileName ManifestFileName *.class 资源文件

更新清单文件
jar ufm JarFileName ManifestFileName

指定程序入口点
jar cvfe JarFileName resource.ResourceTest *.class  资源文件
```

### 配置信息保存




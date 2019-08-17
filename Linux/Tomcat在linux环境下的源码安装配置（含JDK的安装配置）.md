# Tomcat在linux环境下的源码安装配置（含JDK的安装配置）

- tomcat源码包下载 https://tomcat.apache.org/download-90.cgi

![1563849893659](C:\Users\asus8\AppData\Roaming\Typora\typora-user-images\1563849893659.png)

- 将下载的源码包发送到linux中，解压到自己想要放tomcat的目录，一般都是/usr/local目录下。

  ```shell
  tar zxaf apaceh-tomcat.tar.gz (简写名称，看具体版本) /usr/local/
  ```

- 依次进入目录

  ```shell
  cd /usr/local/apache-tomcat(简写)/bin
  ```

- 执行启动命令

  ```
  ./startup.sh或者./catalina.sh
  ```

  至此tomcat服务启动，可以访问localhost:8080查看



### 一些相关的设置

- 修改服务启动端口

进入到/conf/目录下，打开server.xml

```
cd /user/local/apache-tomcat/conf
vim server.xml
```

![1563851367477](C:\Users\asus8\AppData\Roaming\Typora\typora-user-images\1563851367477.png)

修改8080为别的端口号，即可改变。



### JDK的安装配置

- jdk下载地址https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

  ![1563851719070](C:\Users\asus8\AppData\Roaming\Typora\typora-user-images\1563851719070.png)

1.清除已安装其他版本的jdk

```shell
rpm -qa | grep jdk
rpm -e --nodeps jdk
```

2.上传并解压jdk源码包，设置自己的解压路径如/usr/local/java

```shell
tar zxvf jdk(压缩包名) /usr/local/java
```

3.配置环境变量

```shell
vim /etc/profile
```

添加如下内容

![1563858311001](C:\Users\asus8\AppData\Roaming\Typora\typora-user-images\1563858311001.png)

之后刷新环境配置

```shell
source /etc/profile
```

4.输入java -version查看是否安装成功
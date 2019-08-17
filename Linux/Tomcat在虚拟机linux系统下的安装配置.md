## Tomcat在虚拟机linux系统下的安装配置

```shell
1、通过yum直接下载tomcat
#yum install tomcat

2、下载安装完成后，启动tomcat服务
# systemctl start tomcat

可通过# systemctl status tomcat 
查看tomcat服务是否开启。

```

![1563182886227](C:\Users\DH\AppData\Roaming\Typora\typora-user-images\1563182886227.png)



- 此时打开主机浏览器输入虚拟机ip：8080，发现并不能访问下面的界面(虚拟机ip可通过：ip addr 命令查看)

![1563182994586](C:\Users\DH\AppData\Roaming\Typora\typora-user-images\1563182994586.png)

这是因为tomcat的web页面是需要安装插件的，这里继续用 tomcat-webapps 和 tomcat-admin-webapps 两个插件包

```shell
# yum install tomcat-webapps tomcat-admin-webapps
安装完成再次访问就OK了
```


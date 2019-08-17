# Linxu系统下Apache的源码安装

1.准备安装包和辅助包

- **apr**          

- **apr-util**

  上面两个包的下载地址：http://apr.apache.org/download.cgi

  ![1563345972305](C:\Users\asus8\AppData\Roaming\Typora\typora-user-images\1563345972305.png)

- **pcre**  下载地址:[ftp://ftp.csx.cam.ac.uk/pub/software/programming/pcre/](ftp://ftp.csx.cam.ac.uk/pub/software/programming/pcre/)

  ![1563346031075](C:\Users\asus8\AppData\Roaming\Typora\typora-user-images\1563346031075.png)

- **httpd**  下载地址：http://httpd.apache.org/download.cgi#apache24

  ![1563346081457](C:\Users\asus8\AppData\Roaming\Typora\typora-user-images\1563346081457.png)

  



2.安装工作

在linux系统中，将刚刚下载的四个包复制到一个目录下，我的目录是/root/apache/,再将他们解压，解压可在终端完成，命令如下

```she
[root@localhost apache]# tar -zxf apr-1.5.2.tar.gz 
[root@localhost apache]# tar -zxf apr-util-1.5.2.tar.gz 
[root@localhost apache]# tar -zxf httpd-2.4.39.tar.gz 
[root@localhost apache]# tar -zxf pcre-8.41.tar.gz 

```

- apr的安装

  解压完成后进入解压的apr目录,进行配置、编译、安装

  ```she
  # cd apr-1.5.2
  # ./configure --prefix=/usr/local/apr  
  这里的apr目录自己创建(# mkdir /usr/local/apr)
  # make
  # make install
  ```

  

- apr-util的安装

  ```shell
  # cd apr-util-1.5.2
  # ./configure --prefix=/usr/local/apr-util  -with-apr=/usr/local/apr/bin/apr-1-config
  这里的apr-util目录自己创建
  # make
  # make install
  ```



- pcre的安装

  ```she
  # cd pcre-8.41
  # ./configure --prefix=/usr/local/pcre
  # make
  # make install
  ```

- httpd的安装

  ```she
  [root@localhost apache]# cd httpd-2.4.39
  [root@localhost httpd-2.4.39]# ./configure --prefix=/usr/local/apache --with-apr=/usr/local/apr --with-apr-util=/usr/local/apr-util/ --with-pcre=/usr/local/pcre --enable-module=so --enable-mods-shared=all  --enable-module=rewirte  --enable-cache  --enable-file-cache  --enable-mem-cache  --enable-disk-cache  --disable-cgid   --disable-cgi
  [root@localhost httpd-2.4.39]# make
  [root@localhost httpd-2.4.39]# make install
  ```

- 相关依赖的安装，可直接通过yum

  ```shell
  yum -y insatll gcc gcc-c++ zlib zlib-devel 
  ```

  至此安装工作完成。

  

3.apache的简单配置（修改httpd.conf）

```shell
[root@localhost httpd-2.4.39]# cd /usr/local/apache/conf/
[root@localhost conf]# vi httpd.conf
```

将ServerName前的“#”去掉，将www.example.com改成 自己的IP地址

4.启动apache

```shell
[root@localhost conf]# cd /usr/local/apache/bin/
[root@localhost bin]# ./apachectl start
```

## 直接通过yum安装

```shell
yum install httpd -y

#启动
systemctl start httpd
#设置开机自启
systemctl enable httpd
```





### apache的一些目录



![1563859786110](C:\Users\asus8\AppData\Roaming\Typora\typora-user-images\1563859786110.png)


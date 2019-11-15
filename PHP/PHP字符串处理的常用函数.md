## PHP字符串处理的常用函数

### 1.strlen()

返回字符串的长度

```php
strlen($str)
```



### 2.strpos()

查找字符或字符串在另一个字符中的位置，有就返回第一次匹配的索引，没有就返回false

```php
strpos("hello world","world")//返回6
```



### 3.chunk_split()

把字符串分割成一连串更小的部分

```php
chunk_split(string,length,end)
```

| *string* | 必需。规定要分割的字符串。                                   |
| -------- | ------------------------------------------------------------ |
| *length* | 可选。一个数字，定义字符串块的长度。默认为 76。              |
| *end*    | 可选。一个字符串，定义在每个字符串块之后放置的内容。默认为 \r\n。 |



### 4.explode()

将字符串打散为数组

```php
<?php
$str = "www.runoob.com";
print_r (explode(".",$str));
?>   
//以.分割，变成数组
```



### 5.implode()

将数组元素变成字符串

```php
<?php
$arr = array('Hello','World!','Beautiful','Day!');
echo implode(",",$arr);
?>
//将数组内容以，连接
```



### 6.trim()

去除字符串两边的空白或其他预定义字符

```php
trim(string,charlist)//charlist默认为空白
```



### 7.str_replace()

替换字符串中的一些字符

```php
把字符串 "Hello world!" 中的字符 "world" 替换成 "Peter"：

<?php
echo str_replace("world","Peter","Hello world!");
?>
```



### 8.strstr()

```php
查找 "world" 在 "Hello world!" 中是否存在，如果是，返回该字符串及后面剩余部分：

<?php echo strstr("Hello world!","world");  // 输出 world! ?>
```



### 9.substr()

```php
从字符串中返回 "world"：

<?php echo substr("Hello world",6); ?>
```

```php
substr(string,start,length)
```

| *string* | 必需。规定要返回其中一部分的字符串。                         |
| -------- | ------------------------------------------------------------ |
| *start*  | 必需。规定在字符串的何处开始。正数 - 在字符串的指定位置开始负数 - 在从字符串结尾的指定位置开始0 - 在字符串中的第一个字符处开始 |
| *length* | 可选。规定要返回的字符串长度。默认是直到字符串的结尾。正数 - 从 start 参数所在的位置返回负数 - 从字符串末端返回 |


## PHP与JavaScript中数组、字符串相关操作

1. php定义数组

```php
$arr = array('1','2','3');  //普通数组

$arr = array("a"=>"1","b"=>"2","c"=>"3");  //关联数组

$arr = array                              //多维数组
(
    array("Volvo",100,96),
    array("BMW",60,59),
    array("Toyota",110,100)
);
```



2. JavaScript定义数组

```javascript
var arr=new Array("1","2","3");
```



3. php数组与js数组的相互转换

- php->js

```php
<?php
    $arr = array('1','2','3');
    $arr_json = json_encode($arr);
    ?>
        
<script>
    var $jsArr = <?= $arr ?>
<script>
```

- js->php



4. js中对象、数组和json格式的转化

- 对象和json

```javascript
//可以通过JSON.parse()方法将数据转化为JavaScript对象
var arr=JSON.parse(data)  //此处的data为后端传给前端的数据，并且为json格式

//可以通过JSON.stringify()方法将JavaScript对象转为json
var obj = { "name":"runoob", "alexa":10000, "site":"www.runoob.com"};  //obj为js对象
var myJSON = JSON.stringify(obj);   //转为json方便向服务器发送数据
```

- 数组和json

```javascript
var arr = [ "Google", "Runoob", "Taobao", "Facebook" ];
var myJSON = JSON.stringify(arr);

//从服务端接收到数组数据使用JSON.parse()可变为js数组
```

- 对象与数组

```javascript

```



5. php中对象、数组和json格式的转化

- 数组和json

```php
$json_arr = json_encode($arr)  //数组转json
$arr = json_decode($json_arr)  //json转数组
```



+ 对象和json

```php
$json_obj = json_encode($obj)  //对象转json
$obj = json_decode($json_obj)  //json转对象
```



- 对象与数组

```php

```



6. php中数组的遍历

- 遍历数值数组

```php
<?php
$cars=array("Volvo","BMW","Toyota");
$arrlength=count($cars);
 
for($x=0;$x<$arrlength;$x++)
{
    echo $cars[$x];
    echo "<br>";
}
?>
```

- 遍历关联数组

```php
<?php
$age=array("Peter"=>"35","Ben"=>"37","Joe"=>"43");
 
foreach($age as $x=>$x_value)
{
    echo "Key=" . $x . ", Value=" . $x_value;
    echo "<br>";
}
?>
```



7. js中数组的遍历

```javascript
// for循环
    var arr=[2,4,6,10];
    for(let i=0;i<arr.length;i++){
        console.log(arr[i]);
    }

 //for-in 循环
    var arr=[2,4,6,10];
    var index;
    for (index in arr){
        console.log(arr[index]);
    }

//forEach 循环
var array1 = ['a', 'b', 'c'];

array1.forEach(function(element) {
  console.log(element);
});


//for-of循环
    var arr=[3,7,9];
    for (let key of arr){
        console.log(key);
    }

```


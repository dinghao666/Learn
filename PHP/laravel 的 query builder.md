## Laravel 的 Query Builder

### 插入(insert)

#### 1.插入单行数据

```php
DB::table('orders')->insert(
    [
        'price' => 200, // 设置 price 字段值
        'product' => 'Console', // 设置 product 字段值
    ]
);
```

#### 2.插入多行数据

```php
DB::table('orders')->insert(
    [
        ['price' => 400, 'product' => 'Laptop'],
        ['price' => 200, 'product' => 'Smartphone'],
        ['price' => 50, 'product' => 'Accessory'],
    ]
);
```

### 更新（update）

#### 1.使用 `where` 操作符来指定特定记录并更新：

```php
DB::table('orders')
    ->where('price','>','50')
    ->update(['price' => 100]);
```

#### 2.更新或者插入

可能有时候希望更新数据库的现有记录，如果没有则创建（updateOrInsert）

```php
DB::table('users')
    ->updateOrInsert(
        ['email' => 'john@example.com', 'name' => 'John'],
        ['votes' => '2']
    );
```

该语句先查询是否有

```
'email' => 'john@example.com', 'name' => 'John'],
```

的记录，如果有，将该记录中的votes更新为2，没有的话就创建这条记录。



### 删除(delete)

查询构建器还可用于通过该`delete`方法从表中删除记录。您可以在调用方法之前`delete`通过添加`where`子句来约束语句`delete`：

```php
DB::table('users')->delete();

DB::table('users')->where('votes', '>', 100)->delete();
```

如果您希望截断整个表，这将删除所有行并将自动递增ID重置为零，您可以使用以下`truncate`方法：

```php
DB::table('users')->truncate();
```



### 查询

#### 1.查询单个记录（find）

```php
$order = DB::table('orders')->find(3); 

//该返回的$order是一个对象，如果没有记录，则返回空，且find以id作为主键查询
```

#### 2.查询当前表中所有的记录（get）

```php
$orders = DB::table('orders')->get();
```

#### 3.查询包含特定列的记录

```php
$orders = DB::table('orders')->get(['id','price']);
```

#### 4.查询有限数量的记录（take操作符）

```php
$orders = DB::table('orders')->take(50)->get();
```

该查询语句最多查到50条记录。

#### 5.带条件检索单行

```php
$user = DB::table('users')->where('name', 'John')->first();

echo $user->name;
```

该查询语句返回一个name=John的对象。

若只需要返回某个特定的值

```php
$email = DB::table('users')->where('name', 'John')->value('email');
```

该语句返回一个Email值

#### 6.选择指定语句

您可能并不总是希望从数据库表中选择所有列。使用该`select`方法，您可以`select`为查询指定自定义子句：

```php
$users = DB::table('users')->select('name', 'email as user_email')->get();
```

如果您已经有一个查询构建器实例，并且希望在其现有select子句中添加一列，则可以使用以下`addSelect`方法：

```php
$query = DB::table('users')->select('name');

$users = $query->addSelect('age')->get();
```

####　7.获取单列值的集合

```php
$titles = DB::table('roles')->pluck('title');
//该语句获取角色表中title的集合
```

你还可以在返回的集合中指定字段的自定义键值：

```php
$roles = DB::table('roles')->pluck('title', 'name');
foreach ($roles as $name => $title) {
echo $title;
}
//我们可以将全部 users 表数据切割成一次处理 100 条记录的一小块：
```

你可以通过在 `闭包` 中返回 `false` 来终止继续获取分块结果：

```php
DB::table('users')->orderBy('id')->chunk(100, function ($users) {
    // Process the records...

    return false;
});
```

如果要在分块结果时更新数据库记录，则块结果可能会和预计的返回结果不一致。 因此，在分块更新记录时，最好使用 `chunkById` 方法。 此方法将根据记录的主键自动对结果进行分页：

```php
DB::table('users')->where('active', false)
    ->chunkById(100, function ($users) {
        foreach ($users as $user) {
            DB::table('users')
                ->where('id', $user->id)
                ->update(['active' => true]);
        }
    });
```



#### 8.分块查询

当数据库数据较多，可以使用chunk方法获取数据库中的一小块

```php
DB::table('users')->orderBy('id')->chunk(100, function ($users) {
    foreach ($users as $user) {
        //
    }
});
```



### 其他的一些常用操作

#### 1.聚合

查询生成器还提供了多种聚合方法，例如`count`，`max`，`min`，`avg`，和`sum`。在构造查询后，您可以调用以下任何方法：

```php
//查看记录数
$users = DB::table('users')->count();
//查出价格最高的记录
$price = DB::table('orders')->max('price');
```

```php
$price = DB::table('orders')
                ->where('finalized', 1)
                ->avg('price');
```

#### 2.确定是否存在记录

`count`您可以使用`exists`和`doesntExist`方法，而不是使用该方法来确定是否存在与查询约束匹配的任何记录。

```php
return DB::table('orders')->where('finalized', 1)->exists();

return DB::table('orders')->where('finalized', 1)->doesntExist();
```

#### 3.select

- 指定select语句

```php
$users = DB::table('users')->select('name', 'email as user_email')->get();
```

- `distinct` 方法会强制让查询返回的结果不重复：

```php
$users = DB::table('users')->distinct()->get();
```

- 如果你已经有了一个查询构造器实例，并且希望在现有的查询语句中加入一个字段，那么你可以使用 `addSelect`方法：

```php
$query = DB::table('users')->select('name');
$users = $query->addSelect('age')->get();
```

#### 4.原生表达式

有时候你可能需要在查询中使用原生表达式。你可以使用 `DB::raw` 创建一个原生表达式：

```php
$users = DB::table('users')
->select(DB::raw('count(*) as user_count, status'))
->where('status', '<>', 1)
->groupBy('status')
->get();
//使用原生表达式要防止sql注入
```



#### 5.连接语句（join）

递给`join`方法的第一个参数是您需要连接的表的名称，而其余参数指定连接的列约束。您甚至可以在单个查询中加入多个表：

```php
$users = DB::table('users')
            ->join('contacts', 'users.id', '=', 'contacts.user_id')
            ->join('orders', 'users.id', '=', 'orders.user_id')
            ->select('users.*', 'contacts.phone', 'orders.price')
            ->get()
```



如果要执行“左连接”或“右连接”而不是“内连接”，请使用`leftJoin`或`rightJoin`方法。这些方法与方法具有相同的签名`join`：

```php
$users = DB::table('users')
            ->leftJoin('posts', 'users.id', '=', 'posts.user_id')
            ->get();

$users = DB::table('users')
            ->rightJoin('posts', 'users.id', '=', 'posts.user_id')
            ->get();
```



#### 6.合并结果集(UNION)

查询构建器还提供了将两个查询“联合”在一起的快速方法。例如，您可以创建初始查询并使用该`union`方法将其与第二个查询联合：

```php
$first = DB::table('users')
            ->whereNull('first_name');

$users = DB::table('users')
            ->whereNull('last_name')
            ->union($first)
            ->get();
```



#### 7.where语句

```php
$users = DB::table('users')->where('votes', '=', 100)->get();
```

```php
$users = DB::table('users')->where('votes', 100)->get();
```

为方便起见，如果要验证列是否等于给定值，可以将该值直接作为第二个参数传递给`where`方法



您可以将约束链接在一起以及`or`向查询添加子句。该`orWhere`方法接受与方法相同的参数`where`：

```php
$users = DB::table('users')
                    ->where('votes', '>', 100)
                    ->orWhere('name', 'John')
                    ->get();
```

该`whereBetween`方法验证列的值是否在两个值之间：

```php
$users = DB::table('users')
                    ->whereBetween('votes', [1, 100])->get();
```

该`whereNotBetween`方法验证列的值是否在两个值之外：

```php
$users = DB::table('users')
                    ->whereNotBetween('votes', [1, 100])
                    ->get();
```

**whereIn / whereNotIn / orWhereIn /或WhereNotIn**

该`whereIn`方法验证给定列的值是否包含在给定数组中：

```php
$users = DB::table('users')
                    ->whereIn('id', [1, 2, 3])
                    ->get();
```

该`whereNotIn`方法验证给定列的值**不**包含在给定数组中：

```php
$users = DB::table('users')
                    ->whereNotIn('id', [1, 2, 3])
                    ->get();
```

**whereNull / whereNotNull /或WhereNull /或WhereNotNull**

该`whereNull`方法验证给定列的值是`NULL`：

```php
$users = DB::table('users')
                    ->whereNull('updated_at')
                    ->get();
```

该`whereNotNull`方法验证列的值不是`NULL`：

```php
$users = DB::table('users')
                    ->whereNotNull('updated_at')
                    ->get();
```
### 数据库SQL语句

#### 1.一些基本的语句

- 查看数据表

```mysql
desc tablename
```

- 增加表的字段

```mysql
alter table tablename add column columnname int(11)
```

- 修改字段

```mysq
alter table tablename modify columnname char(1)  --只能修改字段类型
```

- 修改字段名

```mysql
alter table tablename change columnnamenew char(1)
```

- 删除字段

```mysql
alter table tablename drop columnname
```

- 重命名字段

```mysql
rename table tablename to newtablename
```

#### 2.模糊查询（LIKE）

- （_）下划线匹配任意一个字符
- （%）百分号匹配任意字符，可以多个

```
select * from tablename where name like 'm_'  -- 匹配以m开头的两个字符的名字
select * from tablename where name like '%m%'  -- 匹配name中包含m的
```

#### 3.字段控制（distinct）

```mysql
select distinct columnname from tablename  --查出该字段中内容去重
```

#### 4.计算

```mysql
select ifnull(column1 + column2,0) from tablename
-- 查出字段1和字段2的和如果为空置零
```

#### 5.排序（order by）

ASC为升序排列，DESC为降序排列

- 组合排序（根据多个维度）

```mysql
order by column1 desc,column2 asc
```



#### 6.聚合函数

- count（统计数据返回的行数）

```mysql
select count(*) from tablename
```

- sum(对字段进行求和)

```mysql
select sum(colunm1),sum(column2) from tablename
-- 这里注意一个数和null相加还是null
```

-  avg（求平均）

- max和min

#### 7.分组查询（group by）

- group_contact (column)  将分组查询到的内容串起来输出

- having 分组后的数据筛选（where 为分组前的数据筛选）

#### 8.分页限制（limit）

```mysql
limit 0,3; --从第0条开始，查询三条记录
```

#### 9.合并结果集（union）

结合多条查询语句，含有去重效果，如果不需要去重可以使用union all

```mysql
select * from tablename1 union select * from tablename2
```

#### 10.连接查询

同时查询多张表，出现笛卡尔积效果（即交叉连接）一般用不到

##### 内连接（inner join）

```mysql
SELECT a.runoob_id, a.runoob_author, b.runoob_count FROM runoob_tbl a INNER JOIN tcount_tbl b ON a.runoob_author = b.runoob_author;
```

内连接分为等值连接、非等职连接以及自连接

- 自连接

```mysql
select * from reply r1 join reply r2 on r1.reply_id = r2.parent_id
```

这里的查询语句查询的是同一张表，代表某个评论还有评论，可以使用自连接查询。

##### 外连接（outer join）

外连接分为左连接和右连接

- 左连接

```mysql
select * from tablename1 left join tablename2 where ....
```

列出左表中所有的数据，如果没有与查询条件匹配的，则以空值显示

- 右连接

```mysql
select * from tablename1 right join tablename2 where ....
```

##### 多表查询语句

```mysql
select *from `user` u join topic t on ...join reply r on ...
```

#### 11.子查询

在select语句中嵌套select语句

```mysql
select * from (select * from tablename where id between 1 and 10) temp where name=丁浩
```

这里将内嵌的查询语句查出来的结果作为一张临时表temp继续进行查询

1. 子查询放在括号内
2. 子查询一般放在条件的右侧
3. 标量自查询一般搭配着单行操作符使用
   < > != = <> <= >=
   列子查询一般搭配着多行操作符来使用、
   in any/some all

4. 子查询的执行顺序要优先于主查询执行，主查询的条件使用到了子查询的条件

- 标量子查询

一般跟在where和having的后面作为限制条件

```mysql
#(2)查询员工信息，满足条件salary>(1)的
SELECT * 
FROM employees
WHERE salary>(
	SELECT salary 
	FROM employees
	WHERE last_name='Abel'
);
```



- 列子查询

> 理解in/not in
> in:只要符合其中一个条件就可以—>a in (10,20,30)(a等于后面的其中一个条件就可以)
> 等价于a=any(10,20,30)
> not in:只要不符合任意一个条件就可以—>a in (10,20,30)(a不等于后面的其中任意一个条件就可以)
> 等价于a <>ALL(10,20,30)

>  理解any/some
> any：只要符合其中一个条件就可以—>a > (10,20,30)(a只要大于后面的其中一个就可以)即大于最小值即可（min代替）

>  理解all
> all：要符合任意一个条件就可以—>a > (10,20,30)(a要大于后面的任意一个)即大于最大值即可（max代替）
>


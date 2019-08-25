## hashCode、equals()和“==”之间的关系

- 在Object类中

“==”和“equals()”比较的都是内存地址。

- 在String类中

重写了equals（）方法和hashCode，equals()变为比较字符串的内容。



hashCode相同，不一定是同一对象，但是同一个对象的hashCode必然相同。



当比较基本数据类型时 “==” 比较的是值。



```java
public class FirstTest {
    public static void main(String[] args) {
        String s1 = "xyz";
        String s2 = new String("xyz");
        System.out.println(s1.hashCode());     //119193
        System.out.println(s2.hashCode());    //119193
        System.out.println(s1 == s2);        //false
        System.out.println(s1.equals(s2));  //true

    }
}

```


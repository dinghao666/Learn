## hashCode、equals()和“==”之间的关系

- 在Object类中

“==”和“equals()”比较的都是内存地址。

- 在String类中

重写了equals（）方法和hashCode，equals()变为比较字符串的内容。



hashCode相同，不一定是同一对象，但是同一个对象的hashCode必然相同。



*注意：当此方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。如下：*

*(1)当obj1.equals(obj2)为true时，obj1.hashCode() == obj2.hashCode()必须为true* 
*(2)当obj1.hashCode() == obj2.hashCode()为false时，obj1.equals(obj2)必须为false*

object类中hashcode是根据对象的内存地址算出来的，所有在不重写hashcode的情况下，一个对象对应一个hashcode，不可能出现不同对象的hashcode相同的情况，当重写了equals方法，可能会出现两个不同的对象equals为true，若不重写hashcode，则这两个对象的hashcode必然不同。

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


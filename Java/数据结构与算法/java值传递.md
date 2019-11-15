## Java值传递

在Java中，只有值传递，并没有引用传递这一说法，主要的混淆点就在于例如在一个方法中传入一个对象时，改变对象的属性，则原来的对象也会变化

```java
//假设我们有一个User类
public static void main(String[],args){
    User user = new User();
    user.name = "丁浩";
    user.age = "18";
    change(user);
    System.out.println(user.age);//这时候会发现age变成了22
}

public static void change(User user){
    user.age = "22";
}

```

虽然对象的属性也随之发生了变化，但着并不是引用传递，而是因为将user对象所指向的地址传了进去，而改变的是该地址内的内容。
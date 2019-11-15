## 字符串匹配算法和KMP算法

#### 1.暴力匹配算法

```java
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "asdfg";
        String str2 = "sdg";
        System.out.println(violenceMatch(str1,str2));


    }

    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int n1 = s1.length;
        int n2 = s2.length;

        int i = 0;
        int j = 0;

        //开始匹配字符串
        while (i < n1 && j < n2) {
            if (s1[i] == s2[j]) {  //如果匹配成功，即匹配下一个字符串
                i++;
                j++;
            } else {  //如果匹配不成功，那么把i回溯到上次匹配的字符的下一个;j重新置0
                i = i - j + 1;
                j = 0;
            }
        }

        //判断匹配结束
        if (j == n2) {
            return i-j;
        }else{
            return -1;
        }
     }
}
```

#### 2.KMP算法

通过部分匹配表实现回溯j而不回溯i，从而提高匹配的效率

- KMP算法部分匹配表的形成

字符串 “bread”

前缀：b          br        bre     brea

后缀：read    ead     ad       d

部分匹配值就是前缀和后缀的最长的共有元素的长度

ABCDABD形成的部分匹配表为：

| A    | B    | C    | D    | A    | B    | D    |
| ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 0    | 0    | 0    | 0    | 1    | 2    | 0    |

**过程**

A 无前缀和后缀  部分匹配值为0

AB 前缀A，后缀B 部分匹配值0

ABC 前缀A、AB，后缀BC 、C  ，部分匹配值0

ABCD 前缀A、AB、ABC，后缀BCD、CD、D 部分匹配值0

ABCDA 前缀A、AB、ABC、ABCD，后缀BCDA、CDA、DA、A 最长共有元素为A 部分匹配值1

ABCDAB 前缀A、AB、ABC、ABCD、ABCDA ，后缀BCDAB、CDAB、DAB、AB、B 最长共有元素AB 部分匹配值2

ABCDABD 前缀A、AB、ABC、ABCD、ABCDA 、ABCDAB，后缀BCDABD、CDABD、DABD、ABD、BD、D  部分匹配值0

**代码实现**

```java
public int[] kmpNext(String str){//求一个字符串str的部分匹配表
    int[] next = new int[str.length()];//定义一个存放部分匹配表的数组
    next[0] = 0;
    for(int i = 1,j = 0; i < str.length(); i++){
        //看新添加的字符和之前的字符是否相同
        //如果不等，那么
        while(j > 0 && str.charAt(i) != str.charAt(j) ){
            j = next[j-1];
        }
        if(str.charAt(i) == str.charAt(j)){//此时的charAt(i)表示的是计算当前部分匹配值的字符串的最后一个，这里的j一开始必定是从0开始的，除非之前有过最长共有元素
            j++;   
        }
        next[i] = j;   
    }
    return next; 
}



public static int[] getNext(String ps) {

    char[] p = ps.toCharArray();
    int[] next = new int[p.length];

    next[0] = -1;
    int j = 0;
    int k = -1;

    while (j < p.length - 1) {
       if (k == -1 || p[j] == p[k]) {
           next[++j] = ++k;
       } else {
           k = next[k];
       }

    }

    return next;

}
```

```java
public static int kmpAlgorithm(String str1,String str2,int[] next){
        for (int i = 0,j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                //发现不匹配，将j回溯到已匹配字符串的部分匹配值位置
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                //匹配到，就把j后移一位
                j++;
            }
            if (j == str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }
```


# 64. SumNums

## 1. 解题思路

### 1.1 平均计算

本题在简单问题上做了许多限制，需要使用排除法一步步导向答案。$1+2+...+(n-1)+n$ 的计算方法主要有三种：**平均计算、迭代、递归**。

**问题：** 此计算必须使用 **乘除法** ，因此本方法不可取，直接排除。

```java
public int sumNums(int n) {
    return (1 + n) * n / 2;
}
```

### 1.2 迭代

**问题：** 循环必须使用 while 或 for ，因此本方法不可取，直接排除。

```java
public int sumNums(int n) {
    int res = 0;
    for(int i = 1; i <= n; i++)
        res += i;
    return res;
}
```

### 1.3 递归

**问题：** 终止条件需要使用 if ，因此本方法不可取。
		**思考：** 除了 if和 switch 等判断语句外，是否有其他方法可用来终止递归？

```java
public int sumNums(int n) {
    if(n == 1) return 1;
    n += sumNums(n - 1);
    return n;
}
```

**逻辑运算符的短路效应**

常见的逻辑运算符有三种，即 “与 \&\& ”，“或 || ”，“非 ! ” ；而其有重要的短路效应，如下所示：

```
if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false

if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true
```

本题需要实现 “当$ n = 1$ 时终止递归” 的需求，可通过短路效应实现。

```
n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
```

**复杂度分析：**

- 时间复杂度 $O(n)$： 计算 $n + (n-1) + ... + 2 + 1$ 需要开启 $n$ 个递归函数。
- 空间复杂度 $O(n)$ ： 递归深度达到 $n$，系统使用 $O(n)$大小的额外空间。


![](../img/64_sumNums.jpg)

## 2. 实现代码

```java
int sum =  0;
public int sumNums(int n) {
    boolean x = (n > 1 && sumNums(n-1) > 0);
    sum += n;
    return sum;
}
```


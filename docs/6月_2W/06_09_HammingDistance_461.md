# 461. HammingDistance

## 1. 解题思路

[汉明距离](https://baike.baidu.com/item/汉明距离/475174?fr=aladdin)广泛应用于多个领域。在编码理论中用于错误检测，在信息论中量化字符串之间的差异。

------

两个整数之间的汉明距离是对应位置上数字不同的位数。

------

根据以上定义，提出一种 [XOR](https://baike.baidu.com/item/异或) 的位运算(异或运算)，当且仅当输入位不同时输出为 1。

![](https://pic.leetcode-cn.com/Figures/461/461_XOR.png)

计算 `x` 和 `y` 之间的汉明距离，可以先计算 `x XOR y`，然后统计结果中等于 1 的位数。

## 2. 解题方法

### 2.1 布赖恩·克尼根算法

跳过两个 1 之间的 0。例如：10001000。上面例子中，遇到最右边的 1 后，如果可以跳过中间的 0，直接跳到下一个 1，效率会高很多。这是布赖恩·克尼根位计数算法的基本思想。该算法使用特定比特位和算术运算移除等于 1 的最右比特位。

在 `number` 和 `number-1` 上做 AND 位运算时，原数字 `number` 的最右边等于 1 的比特会被移除。

![](https://pic.leetcode-cn.com/Figures/461/461_brian.png)

## 3. 解题代码

### 3.1 布莱恩-克尼根算法

```java
public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int distance = 0;
    while (xor != 0) {
        distance += 1;
        // remove the rightmost bit of '1'
        xor = xor & (xor - 1);
    }
    return distance;
}
```


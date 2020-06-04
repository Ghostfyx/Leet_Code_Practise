# 238. 除自身以外数组的乘积

## 1. 解题思路

### 1.1 左右乘积表

不必将所有数字的乘积除以给定索引处的数字得到相应的答案，而是利用索引左侧所有数字的乘积和右侧所有数字的乘积（即前缀与后缀）相乘得到答案。

对于给定索引 i*i*，我们将使用它左边所有数字的乘积乘以右边所有数字的乘积。两次遍历数组，左侧乘积从0开始遍历；右侧乘积从length-1开始遍历。

**算法**

1. 初始化两个空数组 `L` 和 `R`。对于给定索引 `i`，`L[i]` 代表的是 `i` 左侧所有数字的乘积，`R[i]` 代表的是 `i` 右侧所有数字的乘积。
2. 需要用两个循环来填充 L 和 R 数组的值。对于数组 L，L[0] 应该是 1，因为第一个元素的左边没有元素。对于其他元素：$L[i] = L[i-1] * nums[i-1]$。
3. 同理，对于数组 `R`，`R[length-1]` 应为 `1`。`length` 指的是输入数组的大小。其他元素：`R[i] = R[i+1] * nums[i+1]`。
4. 当 `R` 和 `L` 数组填充完成，我们只需要在输入数组上迭代，且索引 `i` 处的值为：`L[i] * R[i]`。

**代码**

```java
public int[] productExceptSelf(int[] nums) {
    int length = nums.length;

    // L 和 R 分别表示左右两侧的乘积列表
    int[] L = new int[length];
    int[] R = new int[length];

    int[] answer = new int[length];

    // L[i] 为索引 i 左侧所有元素的乘积
    // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
    L[0] = 1;
    for (int i = 1; i < length; i++) {
        L[i] = nums[i - 1] * L[i - 1];
    }

    // R[i] 为索引 i 右侧所有元素的乘积
    // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
    R[length - 1] = 1;
    for (int i = length - 2; i >= 0; i--) {
        R[i] = nums[i + 1] * R[i + 1];
    }

    // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
    for (int i = 0; i < length; i++) {
        answer[i] = L[i] * R[i];
    }

    return answer;
}

```

### 1.2 空间复杂度优化的左右乘积表

使用单个值来代替左右乘积表数组，对单个值进行累乘赋值。

```java
public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    int k = 1;
    for(int i = 0; i < res.length; i++){
        res[i] = k;
        // 此时数组存储的是除去当前元素左边的元素乘积
        k = k * nums[i];
    }
    // k依旧赋值等于1
    k = 1;
    for(int i = res.length - 1; i >= 0; i--){
        // k为该数右边的乘积。
        res[i] *= k;
        // 此时数组等于左边的 * 该数右边的。
        k *= nums[i];
    }
    return res;
}
```


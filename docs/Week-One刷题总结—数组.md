# Week—One

第一周LeetCode刷题，在此写下所刷题目，当时的解题思路以及官方的解题思路。后续每周都会进行反思与总结。所刷题目列表如下：

- [x] 1   类型:数组; 题号:1; 难度:简单;
- [x] 7  类型:数组; 题号:7; 难度:简单;
- [x] 9 类型:数组; 题号:9; 难度:简单;
- [ ] 53 类型:数组; 题号:53; 难度:简单; 需要再次练习，总结(1)没有找到合适的解
- [x] 66 类型:数组; 题号:66; 难度:简单;
- [x] 88 类型:数组; 题号:88; 难度:简单;
- [ ] 118 类型:数组; 题号:118; 难度:简单;需要再次练习，总结(1)时有点忘记解法

## 题号1 两数之和

### 题目描述

```
题目描述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
链接：https://leetcode-cn.com/problems/two-sum
```

### 我的解题思路

1. Map数据结构作为中间结果的存储结构；
2. 循环遍历数组nums，将$$target-nums[i]$$的结果作为key，索引$$i$$作为value；
3. 查找Map集合是否有key值存在，如果有则返回i和map.get(key)；
4. 如果没有则按照<key, value>的方式存入map集合中；

### 我的代码

```java
public int[] twoSum(int[] nums, int target) {
        /**
         * 解题思路：
         * 1. 使用HashMap作为临时数据存储结构；
         * 2. 遍历数组，将数组元素作为Map集合的Key，target-nums[i]作为Value；
         * 3. 在遍历过程中如果，出现Value与Key相等的情况则跳出循环，返回结果
         */
        int[] result = new int[2];
        Integer length = nums.length;
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        if (length <= 0){
            return null;
        }
        for (int i = 0 ; i < length; i++){
            int num = nums[i];
            if (temp.containsKey(num)){
                result[0] = i;
                result[1] = temp.get(num);
            }else {
                int subtraction = target - num;
                temp.put(subtraction, i);
            }
        }
        return result;
    }
```

## 题号7 整数反转

### 题目描述

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
题目描述：假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [$$−2^{31}$$,  $$2^{31}-1$$ ]。
请根据这个假设，如果反转后整数溢出那么就返回 0。
链接：https://leetcode-cn.com/problems/reverse-integer/

### 我的解题思路一

1. 将数字转换为字符串；
2. 如果为正整数，则在数字最开头加上“+”号；
3. 对第i位之后的字符串进行反转；

存在缺点：没有对数字边界进行校验，并且没有考虑到进行反转后数字越界的情况

### 官方解题思路

分析题目，反转数字，就是将数字对应的头尾及其后续对应的位置进行互换。具体步骤如下：

1. 从个位数（对num % 10）开始反转，定义反转后的数reverse=0；
2. 判断反转后的数字是否越界，不越界的情况下将reverse*10+当前位数字；
3. 这样个位数每次遍历都会向前一位，当数字到最高位，个位数一直乘以10到最高位；
4. 其他位数上的数字，例如十位数，都会反转；

### 我的代码

```java
public static int reverse_2(int x) {
        /**
         * 解题思路：使用数学的方式去计算
         * 对输入的数字除以10取余
         */
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
```

**注意**：

```java
Java Integer类型，最大值和最小值的范围就是题目要求的整数范围
Integer  public static final int   MIN_VALUE = 0x80000000;

Integer  public static final int   MAX_VALUE = 0x7fffffff;
```

## 题号9 回文数

### 题目描述

```
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
```

### 我的解题思路

1. 借用第7题的思路，将原来的整数除余反转得到整数；
2. 将得到的整数与原整数比较
3. 边界判断：如果整数小于0或者为10的倍数，则必不是回文数

### 官方解题思路

1. 反转后一半的数字，与前一半的数字进行比较；
2. 后续思路如下代码注解

### 官方代码

```java
public static boolean isPalindrome_2(int x){
        /**
         * 官方解题思路：
         * 1. 将整数从中间分隔，反转后一半的数字与前一半的数字比较
         * 2. 避免了数字过长引发的内存溢出，时间复杂度：O(\log_{10}(n))
         */
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x >= 0 && x < 10){
            return true;
        }
  			int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
  			// 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
  }
```

## 题号53 最大子序列和

### 题目描述

```
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
```

### 官方题解

- 使用单个数组作为输入来查找最大（或最小）元素（或总和）的问题，贪心算法是可以在线性时间解决的方法之一。

- 每一步都选择最佳方案，到最后就是全局最优的方案。

	**算法：**
	该算法通用且简单：遍历数组并在每个步骤中更新：

- 当前元素

- 当前元素位置的最大和

- 迄今为止的最大和

 ![](https://pic.leetcode-cn.com/19a5e92ccddfcb29d709541d879a4035cd78f263adf19a74343b9ea464fb8d45-file_1576478143577)

```java
public int maxSubArray(int[] nums) {
        /**
         */
        int length = nums.length;
        if (length == 1){
            return nums[0];
        }
        int currSum = nums[0], maxSum = nums[0];
        for (int i = 1; i< length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
```

## 题号66 Plus One

### 题目描述

```
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。
```

### 我的解题思路

1. 从个位数开始+1，如果+1之后的数%10的余数等于0，则继续循环，否则跳出循环，返回结果
2. 如果循环没有break，则新建原数组长度+1的新数组，将第0位置为1；

### 我的代码

```java
for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        ## 精髓！新建int数组初始化为：[0,0,0,0]
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
```

## 题号88 有序数组合并

### 题目描述

```
题目描述：给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
```

### 我的解题思路 双指针 / 从后往前

![](https://pic.leetcode-cn.com/358c5531639dff237d3a5b7d51d101f652d6409ff6a24f4ca601a277a4b859c5-image.png)

![](https://pic.leetcode-cn.com/57c1daae7dab21c175f0a3acc18e4535aecde350c5100832bd2fdb0e4279180e-image.png)

1. 将nums2的最大数与nums1的最大数进行比较，将大数放于nums1的数组最后一位，并移动指针

### 我的代码

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
 // two get pointers for nums1 and nums2
    int p1 = m - 1;
    int p2 = n - 1;
    // set pointer for nums1
    int p = m + n - 1;
    while ((p1 >= 0) && (p2 >= 0))
      // compare two elements from nums1 and nums2 
      // and add the largest one in nums1 
      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
    // add missing elements from nums2
    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
}
```

## 题号118 杨辉三角形

### 题目描述

```
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
```

### 我的思路

![](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

1. 分析杨辉三角形，每一行的头尾都是1，第i($$i > 2$$)行的数据等于第$$i-1$$行的元素两两相加的结果
2. 初始化第一行数据；
3. 从第二行开始遍历，初始化当前行第一个元素为1，获取前一行的数据，设置指针指向当前行的第一个元素j；
4. 获取前一行的第$$j-1$$和$$j$$ 个元素相加之和；
5. 将最后一个元素设置为1；

### 我的代码

```java
public static List<List<Integer>> generate(int numRows) {
  List<List<Integer>> result = new ArrayList<List<Integer>>();
  ## 初始化第一行
  result.add(new ArrayList<Integer>());
  result.get(0).add(1);
  for(int i = 1; i < numRows; i++){
    List<Integer> row = new ArrayList<Integer>();
    List<Integer> prevRow = result.get(i-1);
    row.add(1);
    for(int j = 1; j < i; j++){
      row.add(prevRow.get(j-1) + prevRow.get(j));
    }
    row.add(1);
    result.add(row);
  }
  return result;
}
```


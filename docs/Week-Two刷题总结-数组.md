# Week-Two刷题总结—数组

第二周（2020-1-10）LeetCode刷题，在此写下所刷题目，当时的解题思路以及官方的解题思路。后续每周都会进行反思与总结。所刷题目列表如下：

- [x] 119 类型:数组; 题号:119; 难度:简单;
- [ ] 121 类型:数组; 题号:121; 难度:简单; 需要再做
- [x] 167 类型:数组; 题号:167; 难度:简单;
- [x] 169 类型:数组; 题号:169; 难度:简单;

## 题号119 杨辉三角形 II

### 题目描述

给定一个非负索引 *k*，其中 *k* ≤ 33，返回杨辉三角的第 *k* 行。

![](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

### 我的解题思路

1. 初始化数据，第一行集合均为$[1]$；
2. 寻找当前行与上一行的规律，当前行$j$的当前元素$i$等于$j-1$行的$(i-1,i)$元素之和；
3. 为了模拟第$j-1$行相邻元素相加得到第$j$行元素，在初始化之后的数组第一个位置插入0；
4. 当前项等于前一项前后添零累加：$[1,4,6,4,1] = [0,1,3,3,1] + [1,3,3,1,0]$

### 我的代码

```python
def getRow(rowIndex):
    # j行的数据, 应该由j - 1行的数据计算出来.
    # 假设j - 1行为[1,3,3,1], 那么我们前面插入一个0(j行的数据会比j-1行多一个),
    # 然后执行相加[0+1,1+3,3+3,3+1,1] = [1,4,6,4,1], 最后一个1保留即可.
    r = [1]
    for i in range(1, rowIndex + 1):
        r.insert(0, 0)
        # 因为i行的数据长度为i+1, 所以j+1不会越界, 并且最后一个1不会被修改.
        for j in range(i):
            r[j] = r[j] + r[j + 1]
    return r
```

## 题号121 股票最佳时机

### 题目描述

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。注意你不能在买入股票前卖出股票。

### 大佬的解题思路

1. 使用动态规划的方式解题，动态规划的学习见后面笔记，在此放下大佬的解题思路：

	[https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/]:动态规划通用思路

### 大佬代码

```java
public int maxProfit(int prices[]) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
```

## 题号167 两数之和 II - 输入有序数组

### 题目描述

给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

### 我的解题思路

1. 使用map散列表作为中间计算结果存放的数据结构
2. key = target - nums[i], value = i

### 我的代码

```java
public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> tempResult = new HashMap<Integer, Integer>();
        int length = numbers.length;
        int[] result = new int[2];
        for (int i = 0; i < length; i++){
            if (tempResult.containsKey(numbers[i])){
                result[0] = tempResult.get(numbers[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            int otherResult = target - numbers[i];
            tempResult.put(otherResult, i);
        }
        return result;
    }
```

### 其他解题思路

1. 双指针的方式，因为是有序数组，因此可以控制头尾指针移动来对两数之和的值进行控制，避免了冗余的中间结果存储空间；

### 其他代码

```java
public static int[] twoSum2(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high){
            int sum = numbers[low] + numbers[high];
            if (sum > target){
                high --;
            }else if (sum < target){
                low ++;
            }else {
                return new int[]{low +1, high +1};
            }
        }
        return new int[]{-1, -1};
    }
```

## 题号169 多数元素

### 题目描述

给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于$\frac{n}{2}$的元素。你可以假设数组是非空的，并且给定的数组总是存在多数元素。

### 我的解题思路

使用一个HashMap散列表作为中间记数结果

### 我的代码

```java
public int majorityElement(int[] nums) {
        int maxNum = 0;
        int maxCount = 0;
        HashMap<Integer, Integer> numsCount = new HashMap<Integer, Integer>();
        for (int num : nums){
            // java8 map集合新特性
            int numCount = numsCount.getOrDefault(num, 0) + 1;
            if (numCount >= maxCount){
                maxNum = num;
                maxCount = numCount;
            }
            numsCount.put(num, numCount);
        }
        return maxNum;
    }
```

### 大佬的解题思路

本题的最终目的是求解众数，大神的解法：使用摩尔投票法（Boyer-Moore 投票算法）求解。详细解题思路如下：

如果我们把众数记为 $+1$ ，把其他数记为 -1 ，将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多。因此，上面的过程说明了我们可以放心地遗忘前面的数字，并继续求解剩下数字中的众数。最后，总有一个后缀满足计数器是大于 0 的，此时这个后缀的众数就是整个数组的众数。

### 大佬的代码

```java
public int majorityElement_2(int[] nums) {
        // 初始count = 1，众数位第一个数
        int count = 1;
        int mode = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (count == 0){
                mode = nums[i];
                count = 1;
                continue;
            }
            if (nums[i] != mode) count --;
            else count ++;
        }
        return mode;
    }
```


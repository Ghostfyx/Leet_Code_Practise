# 1431. KidsWithCandies 

## 1. 解题思路

（1）找出最大数；

（2）遍历数组，每个元素加上额外糖果数，与最大整数相比；

## 2. 解题源码

```java
 public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++){
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++){
            result.add(i, (candies[i] + extraCandies >= max));
        }
        return result;
    }
```


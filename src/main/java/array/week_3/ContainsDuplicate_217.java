package array.week_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: LeetCode 类型:数组; 题号:217; 难度:简单
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * @Author: FanYueXiang
 * @Date: 2020/1/14 1:00 PM
 */
public class ContainsDuplicate_217 {

    /**
     * 我的解题思路：使用Map散列表作为中间记数的数据结构，遍历整个数组
     * 时间复杂度：O(n),空间复杂度：O(n)
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int num : nums){
            if (numberMap.containsKey(num)) return true;
            numberMap.put(num, 1);
        }
        return false;
    }

}

package array.week_two;

import java.util.HashMap;

/**
 * @Description: LeetCode 类型:数组; 题号:169; 难度:简单
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素
 *
 * @Author: FanYueXiang
 * @Date: 2020/1/9 1:08 PM
 */
public class MajorityElement_169 {

    /**
     * 我的解题思路：使用一个HashMap集合作为中间记数结果
     *
     * @param nums
     * @return
     */
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

    /**
     * 本题的最终目的是求解众数，大神的解法：使用摩尔投票法求解
     *
     * @param nums
     * @return
     */
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

}

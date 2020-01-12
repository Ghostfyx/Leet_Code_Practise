package array.week_one;

import java.util.HashMap;

/**
 * @program: leetcode_practise
 * @description: LeetCode 类型:数组; 题号:1; 难度:简单;
 *
 * 题目描述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author: fanyuexiang
 * @create: 2019-12-17 13:09
 **/
public class TwoSum_1 {
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
}

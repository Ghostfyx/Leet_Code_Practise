package array.week_two;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: LeetCode 类型:数组; 题号:167; 难度:简单;
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * @Author: FanYueXiang
 * @Date: 2020/1/8 1:03 PM
 */
public class twoSum_167 {

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

    public static void main(String[] args){
        int [] numbers = {2,7,11,15};
        twoSum(numbers, 9);
    }
}

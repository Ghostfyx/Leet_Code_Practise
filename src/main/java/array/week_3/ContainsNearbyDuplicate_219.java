package array.week_3;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: LeetCode 类型:数组; 题号:219; 难度:简单
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 *
 * @Author: FanYueXiang
 * @Date: 2020/1/14 1:07 PM
 */
public class ContainsNearbyDuplicate_219 {

    /**
     * 我的思路：使用头尾双指针法来控制滑动窗口的移动，窗口内元素进行比较
     * 时间复杂度很高
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = k-1;
        while (left < right){
            // 执行for循环比较
            if (nums[left] == nums[right]) return true;
            left ++;
            if (right == left){
                right += 3;
                if (right > nums.length-1) right = nums.length-1;
            }
        }
        return false;
    }

    /**
     * 使用set集合的方式控制滑动窗口内的数据
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        // 将set集合看作一个队列，如果不存在重复元素，头部元素出队！
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        containsNearbyDuplicate2(nums, k);
    }
}

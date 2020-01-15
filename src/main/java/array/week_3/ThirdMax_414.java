package array.week_3;

import java.util.TreeSet;

/**
 * @Description: LeetCode 类型:数组; 题号:414; 难度:简单
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。
 * 要求算法时间复杂度必须是O(n)。
 *
 * @Author: FanYueXiang
 * @Date: 2020/1/15 1:16 PM
 */
public class ThirdMax_414 {

    /**
     * 维护一个长度为n的TreeSet集合，与MapReduce，Spark寻找TopN的数据思想一致
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new RuntimeException("error");
        TreeSet<Integer> set = new TreeSet<>();
        int topN = 3;
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
            if (set.size() > topN) set.remove(set.first());
        }
        return set.size() < 3?set.last():set.first();
    }

    /**
     * 使用三个变量one，two，three来存储第一大，第二大和第三大的数字
     * @param nums
     * @return
     */
    public int thirdMax_2(int[] nums) {
        if (nums == null || nums.length == 0) throw new RuntimeException("nums is null or length of 0");
        int n = nums.length;

        int one = nums[0];
        long two = Long.MIN_VALUE;
        long three = Long.MIN_VALUE;

        for (int i = 1; i < n; i++){
            int current = nums[i];
            if (current == one || current == two || current == three) continue;    // 如果存在过就跳过不看
            if (current > one){
                three = two;
                two = one;
                one = current;
            }else if (current > two){
                three = two;
                two = current;
            }else if (current > three){
                three = current;
            }
        }
        if (three == Long.MIN_VALUE) return one;  // 没有第三大的元素，就返回最大值
        return (int)three;
    }

}

package array.week_3;

/**
 * @Description: LeetCode 类型:数组; 题号:268; 难度:简单
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * @Author: FanYueXiang
 * @Date: 2020/1/15 1:04 PM
 */
public class MissingNumber_268 {

    /**
     * 我的思路1：求0-n的和，遍历数组做减法
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (1 + n)*n/2;
        boolean hasZero = false;
        for (int num : nums){
            sum -= num;
            if (num == 0) hasZero = true;
        }
        if (hasZero && sum == 0) return -1;
        else return sum;
    }

    /**
     * 使用位运算的方式，由于异或运算（XOR）满足结合律，
     * 并且对一个数进行两次完全相同的异或运算会得到原来的数，
     * 因此我们可以通过异或运算找到缺失的数字。
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums){
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

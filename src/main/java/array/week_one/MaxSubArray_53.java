package array.week_one;

/**
 * @program: leetcode_practise
 * @description: LeetCode 类型:数组; 题号:53; 难度:简单;
 * 题目描述：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 *
 * @author: fanyuexiang
 * @create: 2019-12-23 13:11
 **/
public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        /**
         * 解题思路：1. 使用分治的方法解决该问题，设置left,right,mid三个指针
         *         2. cross_sum 是包含左右子数组且含索引 (left + right) / 2 的最大值
         *         3. left_sum 为最大子数组前 n/2 个元素，在索引为 (left + right) / 2 的元素属于左子数组
         *         4. right_sum 为最大子数组的右子数组，为最后 n/2 的元素。
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

    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 如果我们从结尾开始改写 nums1
         * 这里的指针 p 用于追踪添加元素的位置
         */
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)){
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}

package array.week_one;

/**
 * @program: leetcode_practise
 * @description: LeetCode 类型:数组; 题号:53; 难度:简单;
 * 题目描述：给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * @author: fanyuexiang
 * @create: 2019-12-25 13:04
 **/
public class merge_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 解题思路：假设：nums_1有足够的空间存放nums_1+nums_2
         * 1. 对数组2进行遍历，查找在数组1中第一个大于其的元素j，插入在j前面
         */
        for (int i = 0; i < n; i++){
            int current = nums2[i];
            int index = findIndex(nums1, current, 0, nums1.length-1);
            if (index < nums1.length - 1){
                // 对nums1数组插入元素
                insertData(nums1, index, current);
            }else {
                // 将nums2剩余元素全部插入nums1的尾部

            }
        }
    }

    public int findIndex(int[] nums, int data, int left, int right){
        int mid = (right - left)/2;
        while (mid > left){
            if (data > nums[mid]){
                left = mid;
                findIndex(nums, data, left, right);
            }else {
                right = mid;
                findIndex(nums, data, left, right);
            }
        }
        return mid;
    }

    public void insertData(int[] nums, int index, int data){
        for (int i = nums.length-1; i >= index; i--){
            int temp = nums[i];
            nums[i+1] = temp;
        }
        nums[index] = data;
    }
}

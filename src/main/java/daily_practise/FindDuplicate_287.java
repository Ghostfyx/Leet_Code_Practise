package daily_practise;

/**
 * @description:
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 说明：
 *  1.不能更改原数组（假设数组是只读的）。
 *  2.只能使用额外的 O(1) 的空间。
 *  3.时间复杂度小于 O(n^2) 。
 *  4.数组中只有一个重复的数字，但它可能不止重复出现一次
 *
 * @author: fanyeuxiang
 * @createDate: 2020-05-26 12:36
 */
public class FindDuplicate_287 {

    /**
     * 参考了官方解法，使用二分法
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int right = len - 1;
        int left = 1;
        while (left < right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args){
       int[] nums =  new int[]{1,3,4,2,2};
       System.out.println(findDuplicate(nums));
    }
}

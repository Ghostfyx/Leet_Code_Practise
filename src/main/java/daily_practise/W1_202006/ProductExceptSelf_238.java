package daily_practise.W1_202006;

/**
 * @description:
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * @author: fanyeuxiang
 * @createDate: 2020-06-04 12:58
 */
public class ProductExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            res[i] = k;
            // 此时数组存储的是除去当前元素左边的元素乘积
            k = k * nums[i];
        }
        // k依旧赋值等于1
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            // k为该数右边的乘积。
            res[i] *= k;
            // 此时数组等于左边的 * 该数右边的。
            k *= nums[i];
        }
        return res;
    }

}

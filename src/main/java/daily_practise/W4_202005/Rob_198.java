package daily_practise.W4_202005;

/**
 * @description:
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
    示例 1:

    输入: [1,2,3,1]
    输出: 4
    解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
         偷窃到的最高金额 = 1 + 3 = 4 。
    示例 2:

    输入: [2,7,9,3,1]
    输出: 12
    解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
         偷窃到的最高金额 = 2 + 9 + 1 = 12 。

 *
 * @author: fanyeuxiang
 * @createDate: 2020-05-29 12:44
 */
public class Rob_198 {

    /**
     * 题目分析：
     *  1.每家每户的资金肯定是正数，所以起始位置必然是第一户或者第二户，结束位置必然是最后一户或者倒数第二户
     *  只需要依次计算出每个位置最大的价值即可，使用动态规划的思想 dp[n] = MAX( dp[n-1], dp[n-2] + num )
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] robValues = new int[length+1];
        robValues[0] = 0;
        robValues[1] = nums[0];
        for (int i  = 2; i <= length; i++){
            int max = Math.max(robValues[i-1],robValues[i-2]+nums[i-1]);
            robValues[i] = max;
        }
        return robValues[length];
    }

}

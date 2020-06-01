package daily_practise.W4_202005;

import java.util.HashMap;

/**
 * @description:
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * @author: fanyeuxiang
 * @createDate: 2020-05-27 12:30
 */
public class SubarraysDivByK_974 {

    /**
     * 子数组和  -----> 前缀和
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> mokMap = new HashMap<>();
        Integer persum = 0;
        Integer count = 0;
        mokMap.put(0, 1);
        for (int i = 0; i< A.length; i++){
            persum = (persum + A[i]) % K;
            if (persum < 0) persum += K;
            if (mokMap.containsKey(persum)) {      // 之前存过的 与当前preSum相等的key
                count += mokMap.get(persum);  // 把它出现的次数累加给count
            }
            if (mokMap.containsKey(persum)){
                // 以前存过，出现次数+1
                int temp = mokMap.get(persum);
                mokMap.replace(persum, temp+1);
            } else {                // 新存入，初始值1
                mokMap.put(persum, 1);
            }
        }
        return count;
    }

}

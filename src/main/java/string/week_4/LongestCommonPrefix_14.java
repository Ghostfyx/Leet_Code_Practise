package string.week_4;

/**
 * @Description: LeetCode 类型:字符串; 题号:14; 难度:简单
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * @Author: FanYueXiang
 * @Date: 2020/2/4 1:19 PM
 */
public class LongestCommonPrefix_14 {

    /** 使用水平扫描法，依次比较字符串
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(ans) != 0) {
                ans = ans.substring(0, ans.length() - 1);
                if (ans.isEmpty()) return "";
            }
        }
        return ans;
    }

}

package array.week_one;

/**
 * @program: leetcode_practise
 * @description: LeetCode 类型:数组; 题号:7; 难度:简单;
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 *
 * 题目描述：假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 链接：https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author: fanyuexiang
 * @create: 2019-12-18 13:08
 **/
public class ArrayReverse_7 {

    public int reverse(int x) {
        /**
         * 解题思路：
         * 1. 将int转为String
         * 2. 如果是负数则将第二位到最后反转
         *
         * 错误的题解！没有考虑到反转之后会溢出的问题，已经Long型数据的长度限制，转换精度缺失
         */
        String temp = "";
        boolean isNegtive = false;
        if (x > 0){
            temp = String.valueOf(x);
        }else {
            temp = String.valueOf(-x);
            isNegtive = true;
        }
        char[] array = temp.toCharArray();
        String reverse = "";
        for (int i = array.length - 1; i >= 0; i--){
            reverse += array[i];
        }
        if (isNegtive){
            return new Long(reverse).intValue();
        }else {
            return 0-new Long(reverse).intValue();
        }
    }

    public static int reverse_2(int x) {
        /**
         * 解题思路：使用数学的方式去计算
         * 对输入的数字除以10取余
         */
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args){
        reverse_2(321);
    }
}

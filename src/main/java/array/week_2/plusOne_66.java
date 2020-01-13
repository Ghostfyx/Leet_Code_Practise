package array.week_2;

/**
 * @program: leetcode_practise
 * @description: LeetCode 类型:数组; 题号:66; 难度:简单;
 *
 * 题目描述：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author: fanyuexiang
 * @create: 2019-12-24 13:03
 **/
public class plusOne_66 {
    public int[] plusOne(int[] digits) {
        /**
         * 解题思路：因为是10进制的数所以可以利用对10取余判断是否需要进位，需要进位则致为0；
         * 下面的数继续+1，判断对10的取余
         */
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

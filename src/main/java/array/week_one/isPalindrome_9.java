package array.week_one;

/**
 * @program: leetcode_practise
 * @description: LeetCode 类型:数组; 题号:9; 难度:简单;
 * 题目描述：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 *
 * @author: fanyuexiang
 * @create: 2019-12-19 13:06
 **/
public class isPalindrome_9 {

    public static boolean isPalindrome(int x) {
        /**
         * 解题思路：正数包括正数与负数
         * 1. 判断是正数还是负数，将负数过滤
         * 2. 将大于10的数字反转，判断是否等于原数
         *
         * 心得：整数的回文与反转可以用除法取余数，再重新生成另一个整数得到
         */
        boolean isPalindrome = false;
        int rev = 0;
        if (x < 0){
            return isPalindrome;
        }
        if (x >= 0 && x < 10){
            isPalindrome = true;
        }else {
            int temp = x;
            while (temp != 0) {
                int pop = temp % 10;
                temp /= 10;
                rev = rev * 10 + pop;
            }
        }
        if (rev == x) isPalindrome = true;
        return isPalindrome;
    }

    public static boolean isPalindrome_2(int x){
        /**
         * 官方解题思路：
         * 1. 将整数从中间分隔，反转后一半的数字与前一半的数字比较
         * 2. 避免了数字过长引发的内存溢出，时间复杂度：O(\log_{10}(n))
         */
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x >= 0 && x < 10){
            return true;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome_2(121));
    }
}

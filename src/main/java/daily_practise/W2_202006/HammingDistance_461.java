package daily_practise.W2_202006;

/**
 * @description:
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 *  0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * @author: fanyeuxiang
 * @createDate: 2020-06-09 13:13
 */
public class HammingDistance_461 {

    /**
     * 布赖恩·克尼根算法
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        // 异或运算是基于二进制的位运算，采用符号XOR或者^来表示，运算规则是就与二进制，如果是同值取0、异值取1。
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor & (xor - 1);
        }
        return distance;
    }

    public static void main(String[] args){
        int i = 2^4;
        byte j = (byte) i;
        System.out.println(j);
    }

}

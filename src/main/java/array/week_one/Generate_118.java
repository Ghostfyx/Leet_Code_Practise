package array.week_one;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_practise
 * @description: LeetCode 类型:数组; 题号:118; 难度:简单;
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
 * @author: fanyuexiang
 * @create: 2019-12-26 13:09
 **/
public class Generate_118 {
    public static List<List<Integer>> generate(int numRows) {
        /**
         * 解题思路：杨辉三角形是由数组构成的，每一个数组的头尾都是1，中间的元素等于
         */
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        result.add(new ArrayList<Integer>());
        result.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> prevRow = result.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            result.add(row);
        }
        return result;
    }

    public static void main(String[] args){
        generate(5);
    }
}

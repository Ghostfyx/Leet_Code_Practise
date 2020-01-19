package array.week_3;


/**
 * @description: LeetCode 类型:数组; 题号:283; 难度:简单
 *
 * 题目描述：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author: fanyeuxiang
 * @createDate: 2020-01-19 13:03
 */
public class MoveZeroes_283 {

    /**
     * 大神解题思路：思路：可以先把所有非0的元素移到前面，然后将后面的位置补0。
     * 使用指针i，指向需要插入的下标，使用指针j指向遍历的下标。遍历一遍，如果j指向的位置为0，则i不变，j++后移；如果j指向的位置不为0，则将j位置的元素值赋值到i位置，然后i++。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        for (int right=0; right < n; right++){
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left ++;
            }
        }
        //将后面的位置补0
        for(int p = left; p < nums.length; p++){
            nums[p] = 0;
        }
    }

}

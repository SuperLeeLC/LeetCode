import java.util.ArrayList;
import java.util.List;

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 * 原地(in place)解决该问题
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author : lichao
 * @date : 2020/6/24 6:21 下午
 */

public class Solution2 {

    public void moveZeroes(int[] nums) {

        // nums中，[0...k) 均为非0元素
        int k = 0;

        // 遍历到第 i 个元素后，保证 [0...i]中所有非0元素都按顺序排列在[0...k)中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // 将 nums 剩余位置放置为 0
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}

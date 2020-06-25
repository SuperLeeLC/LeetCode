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

public class Solution3 {

    public void moveZeroes(int[] nums) {

        // nums中，[0...k) 均为非0元素
        int k = 0;

        // 遍历到第 i 个元素后，保证 [0...i]中所有非0元素都按顺序排列在[0...k)中
        // 同时，[k...i] 为 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (k != i) {
                    swap(nums, k++, i);
                } else { // i==k 数组中全是非 0 元素
                    k++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}

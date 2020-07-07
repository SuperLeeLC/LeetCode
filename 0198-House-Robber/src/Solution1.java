/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 * 记忆化搜索
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * @author : lichao
 * @date : 2020/7/6 3:42 下午
 */

public class Solution1 {

    // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {

        memo = new int[nums.length];

        return tryRob(nums, 0);
    }

    // 考虑抢劫 nums[index...nums.size()] 这个范围的所有房子
    private int tryRob(int[] nums, int index) {

        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }

        memo[index] = res;

        return res;
    }

}

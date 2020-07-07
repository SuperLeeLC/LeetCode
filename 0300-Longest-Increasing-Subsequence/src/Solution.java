import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * 记忆化搜索
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * @author : lichao
 * @date : 2020/7/7 11:25 上午
 */

public class Solution {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // memo[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, memo[i]);
        }

        return res;
    }

}

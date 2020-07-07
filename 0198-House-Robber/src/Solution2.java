import java.util.Arrays;

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 * 动态规划
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * @author : lichao
 * @date : 2020/7/6 3:42 下午
 */

public class Solution2 {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int[] memo = new int[n];

        memo[n-1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n? memo[j + 2] : 0));
            }
        }

        return memo[0];
    }

}

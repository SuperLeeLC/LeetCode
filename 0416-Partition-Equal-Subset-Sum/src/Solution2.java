import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 * 动态规划
 * 时间复杂度: O(len(nums) * O(sum(nums)))
 * 空间复杂度: O(len(nums) * O(sum(nums)))
 *
 * @author : lichao
 * @date : 2020/7/7 2:47 下午
 */

public class Solution2 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        int c = sum / 2;
        boolean[] memo = new boolean[c + 1];

        for (int i = 0; i <= c; i++) {
            memo[i] = (nums[0] == i);
        }

        for(int i = 1 ; i < n ; i ++) {
            for(int j = c; j >= nums[i] ; j --) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }

        return memo[c];
    }

}

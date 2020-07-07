import java.util.Arrays;

/**
 * @author : lichao
 * @date : 2020/7/5 5:46 下午
 */

public class Solution2 {

    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

}

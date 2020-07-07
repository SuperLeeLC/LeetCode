import java.util.Arrays;

/**
 * @author : lichao
 * @date : 2020/7/5 5:45 下午
 */

public class Solution1 {

    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calcWays(n);
    }

    private int calcWays(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (memo[n] == -1) {
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
        }

        return memo[n];
    }
}

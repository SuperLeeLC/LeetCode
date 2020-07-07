/**
 * @author : lichao
 * @date : 2020/7/6 2:43 下午
 */

public class Solution1 {

    public int integerBreak(int n) {
        return breakInteger(n);
    }

    // 将 n 进行分割（至少分割两部分），可以获得的最大乘积
    private int breakInteger(int n) {

        if (n == 1) {
            return 1;
        }

        int res = -1;

        for (int i = 1; i <= n - 1; i++) {
            // i + (n - i)
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }

        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b,c));
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).integerBreak(2));
        System.out.println((new Solution1()).integerBreak(10));
    }
}

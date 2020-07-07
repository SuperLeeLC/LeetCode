import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/description/
 * 该方法会导致 Time Limit Exceeded 或者 Memory Limit Exceeded
 * 时间复杂度: O(2^n)
 * 空间复杂度: O(2^n)
 *
 * @author : lichao
 * @date : 2020/7/2 8:56 下午
 */

public class Solution3 {

    public int numSquares(int n) {

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                if (a == 0) {
                    return step + 1;
                }
                if (!visited[a]) {
                    queue.addLast(new Pair<>(a, step + 1));
                    visited[a] = true;
                }
            }
        }

        throw new IllegalStateException("No Solution");
    }

    public static void main(String[] args) {
        System.out.println((new Solution3()).numSquares(12));
        System.out.println((new Solution3()).numSquares(13));
    }

}

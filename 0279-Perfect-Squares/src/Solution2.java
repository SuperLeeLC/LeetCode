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

public class Solution2 {

    public int numSquares(int n) {

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if (num == 0) {
                return step;
            }

            for (int i = 1; num - i * i >= 0; i++) {
                if (!visited[num - i * i]) {
                    queue.addLast(new Pair<>(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }

        throw new IllegalStateException("No Solution");
    }

    public static void main(String[] args) {
        System.out.println((new Solution2()).numSquares(12));
        System.out.println((new Solution2()).numSquares(13));
    }

}

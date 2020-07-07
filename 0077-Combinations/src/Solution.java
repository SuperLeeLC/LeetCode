import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. Combinations
 * https://leetcode.com/problems/combinations/description/
 * 时间复杂度: O(n^k)
 * 空间复杂度: O(k)
 *
 * @author : lichao
 * @date : 2020/7/4 4:22 下午
 */

public class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();

        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        LinkedList<Integer> c = new LinkedList<>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    // 求解 C（n,k），当前已经找到的组合存储在 c 中， 需要从 start 开始搜索新的元素
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c) {

        if (c.size() == k) {
            res.add((List<Integer>) c.clone());
            return;
        }

        // 还有k - c.size()个空位, 所以, [i...n] 中至少要有 k - c.size() 个元素
        // i最多为 n - (k - c.size()) + 1
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();
        }

    }

}

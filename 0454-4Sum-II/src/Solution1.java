import java.util.HashMap;
import java.util.Map;

/**
 * @author : lichao
 * @date : 2020/6/29 4:29 下午
 */

public class Solution1 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if (A == null || B == null || C == null || D == null) {
            throw new IllegalArgumentException("Illegal Argument");
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (map.containsKey(0 -A[i] - B[j])) {
                    res += map.get(0 -A[i] - B[j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println((new Solution1()).fourSumCount(a, b, c, d));
    }

}

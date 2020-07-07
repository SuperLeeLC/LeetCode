import java.util.HashMap;
import java.util.Map;

/**
 * @author : lichao
 * @date : 2020/6/29 5:19 下午
 */

public class Solution {

    public int numberOfBoomerangs(int[][] points) {

        int res = 0;

        for (int i = 0; i < points.length; i++) {

            // record 中存储点 i 到所有其他点的距离出现的次数
            Map<Integer, Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    // 计算距离时不进行开根运算，以保证精度
                    int dis = dis(points[i], points[j]);
                    if (record.containsKey(dis)) {
                        record.put(dis, record.get(dis) + 1);
                    } else {
                        record.put(dis, 1);
                    }
                }
            }

            for (Integer dis : record.keySet()) {
                res += record.get(dis) * (record.get(dis) - 1);
            }
        }

        return res;
    }

    private int dis(int[] pa, int[] pb) {
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) + (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((new Solution()).numberOfBoomerangs(points));
    }
}

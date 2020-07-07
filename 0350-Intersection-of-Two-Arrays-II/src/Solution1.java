import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : lichao
 * @date : 2020/6/29 10:19 上午
 */

public class Solution1 {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> record = new HashMap<>();
        for (int num : nums1) {
            if (!record.containsKey(num)) {
                record.put(num, 1);
            } else {
                record.put(num, record.get(num) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (record.containsKey(num) && record.get(num) > 0) {
                result.add(num);
                record.put(num, record.get(num) - 1);
            }
        }

        int[] res = new int[result.size()];
        int index = 0;
        for (Integer num : result) {
            res[index++] = num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution1()).intersect(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}

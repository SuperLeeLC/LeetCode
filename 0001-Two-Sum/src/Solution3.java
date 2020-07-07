import java.util.HashMap;
import java.util.Map;

/**
 * @author : lichao
 * @date : 2020/6/29 3:16 下午
 */

public class Solution3 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                int[] res = {i, record.get(complement)};
                return res;
            }

            record.put(nums[i], i);
        }

        throw new IllegalStateException("The input has no solution");
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] res = new Solution3().twoSum(arr, target);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}

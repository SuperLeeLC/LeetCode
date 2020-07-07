import java.util.HashMap;

/**
 * @author : lichao
 * @date : 2020/6/29 3:16 下午
 */

public class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer index = record.get(target - nums[i]);
            if (index != null && index != i) {
                int[] res = {i, index};
                return res;
            }
        }

        throw new IllegalStateException("The input has no solution");
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] res = new Solution2().twoSum(arr, target);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}

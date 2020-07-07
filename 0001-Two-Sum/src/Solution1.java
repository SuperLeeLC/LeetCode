/**
 * @author : lichao
 * @date : 2020/6/29 3:16 下午
 */

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    int[] res = {i, j};
                    return res;
                }
            }
        }

        throw new IllegalStateException("The input has no solution");
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] res = new Solution1().twoSum(arr, target);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}

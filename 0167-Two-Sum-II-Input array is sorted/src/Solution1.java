/**
 * @author : lichao
 * @date : 2020/6/25 6:57 下午
 */

public class Solution1 {

    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    int[] res = {i+1, j+1};
                    return res;
                }
            }
        }
        throw new IllegalStateException("The input has no solution");
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] res = new Solution1().twoSum(arr, target);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}

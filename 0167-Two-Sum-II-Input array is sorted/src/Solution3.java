/**
 * @author : lichao
 * @date : 2020/6/25 6:57 下午
 */

public class Solution3 {

    public int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                int[] res = {l+1, r+1};
                return res;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        throw new IllegalStateException("The input has no solution");
    }

}

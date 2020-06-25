import java.util.Arrays;

/**
 * @author : lichao
 * @date : 2020/6/25 3:42 下午
 */

public class Solution2 {

    public void sortColors(int[] nums) {
        // nums[0...zero] == 0
        int zero = -1;
        // nums[two...n-1] == 2
        int two = nums.length;

        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else {
                assert (nums[i] == 0);
                zero++;
                swap(nums, zero, i);
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        new Solution1().sortColors(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

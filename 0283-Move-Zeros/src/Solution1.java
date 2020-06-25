import java.util.ArrayList;
import java.util.List;

/**
 *  283. Move Zeroes
 *  https://leetcode.com/problems/move-zeroes/description/
 *  时间复杂度: O(n)
 *  空间复杂度: O(n)
 *
 * @author : lichao
 * @date : 2020/6/24 5:55 下午
 */

public class Solution1 {

    public void moveZeroes(int[] nums) {
        List<Integer> nonZeroElements = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroElements.add(nums[i]);
            }
        }

        for (int i = 0; i < nonZeroElements.size(); i++) {
            nums[i] = nonZeroElements.get(i);
        }

        for (int i = nonZeroElements.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};

        new Solution1().moveZeroes(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

/**
 *  Two Pointers
 *  Time Complexity: O(n)
 *  Space Complexity: O(1)
 *  Source : https://leetcode.com/problems/remove-element/
 *
 * @author : lichao
 * @date : 2020/6/24 8:50 下午
 */

public class Solution1 {

    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3};

        int length = new Solution1().removeElement(arr, 2);
        System.out.println("newLength : " + length);

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

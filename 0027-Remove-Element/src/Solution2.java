/**
 *  Two Pointers
 *  Move the deleted element to the last
 *  This method would be save the unnecessary copy when the removed element is rare.
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(1)
 *  Source : https://leetcode.com/problems/remove-element/
 *
 * @author : lichao
 * @date : 2020/6/24 8:50 下午
 */

public class Solution2 {

    public int removeElement(int[] nums, int val) {

        int i = 0;
        int newLength = nums.length;

        while (i < newLength) {
            if (nums[i] == val) {
                nums[i] = nums[--newLength];
            } else {
                i++;
            }
        }

        return newLength;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3};

        int length = new Solution2().removeElement(arr, 2);
        System.out.println("newLength : " + length);

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

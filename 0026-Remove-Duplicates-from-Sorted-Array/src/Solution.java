/**
 *  Two pointers
 *  Time Complexity:  O(n)
 *  Space Complexity: O(1)
 *  Source : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author : lichao
 * @date : 2020/6/24 10:23 下午
 */

public class Solution {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        int j = 1;

        while (j < nums.length) {

            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }

            j++;
        }

        return i + 1;
    }

    public static void main(String[] args) {
//        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int[] arr = {1,2};

        int length = new Solution().removeDuplicates(arr);
        System.out.println("newLength : " + length);

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

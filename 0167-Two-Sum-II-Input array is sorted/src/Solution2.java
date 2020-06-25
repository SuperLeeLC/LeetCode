/**
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * 二分搜索法
 * 时间复杂度: O(nlogn)
 * 空间复杂度: O(1)
 *
 * @author : lichao
 * @date : 2020/6/25 6:57 下午
 */

public class Solution2 {

    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length - 1; i++) {
            int index = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (index != -1) {
                int[] res = {i + 1, index + 1};
                return res;
            }
        }
        throw new IllegalStateException("The input has no solution");
    }

    private int binarySearch(int[] arr, int l, int r, int target) {

        if(l < 0 || l > arr.length) {
            throw new IllegalArgumentException("l is out of bound");
        }

        if(r < 0 || r > arr.length) {
            throw new IllegalArgumentException("r is out of bound");
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] res = new Solution2().twoSum(arr, target);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}

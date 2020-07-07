/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * 滑动窗口的思路
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author : lichao
 * @date : 2020/6/25 3:10 下午
 */

public class Solution3 {

    public int minSubArrayLen(int s, int[] nums) {

        // nums[l...r] 为滑动窗口
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {
            if (r+1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                res = Math.min(res, r-l+1);
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }

        return res;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] arr = {2,3,1,2,4,3};

        int res = new Solution2().minSubArrayLen(s, arr);

        System.out.println(res);
    }

}

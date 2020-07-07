import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 * 时间复杂度: O(nlogk)
 * 空间复杂度: O(k)
 *
 * @author : lichao
 * @date : 2020/6/29 8:51 下午
 */

public class Solution1 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (record.ceiling((long)nums[i] - (long)t) != null && record.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t) {
                return true;
            }

            record.add((long)nums[i]);

            if (record.size() == k + 1) {
                record.remove((long)nums[i - k]);
            }
        }

        return false;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        printBool((new Solution1()).containsNearbyAlmostDuplicate(nums, k, t));
    }

}

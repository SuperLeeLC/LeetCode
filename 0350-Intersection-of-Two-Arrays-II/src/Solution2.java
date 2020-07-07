import java.math.BigDecimal;
import java.util.*;

/**
 * @author : lichao
 * @date : 2020/6/29 10:19 上午
 */

public class Solution2 {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int index = 0;
        int[] res = new int[result.size()];
        for (Integer num : result) {
            res[index++] = num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution2()).intersect(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}

import java.util.ArrayList;
import java.util.TreeSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> record = new TreeSet<>();
        for (int num : nums1) {
            record.add(num);
        }

        TreeSet<Integer> resultSet = new TreeSet<>();
        for (int num : nums2) {
            if (record.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] res = new int[resultSet.size()];
        int index = 0;
        for (Integer num : resultSet) {
            res[index++] = num;
        }

        return res;
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : lichao
 * @date : 2020/7/4 3:07 下午
 */

public class Solution {

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();

        generatePermutation(nums, 0, p);

        return res;
    }

    /**
     * p 中保存了一个有 index - 1 个元素的排列
     * 向这个排列末尾添加第 index 个元素，获得一个有 index 个元素的排列
     *
     * @param nums
     * @param index
     * @param p
     */
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {

        if (index == nums.length) {
            res.add((List<Integer>) p.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {

                used[i] = true;
                p.addLast(nums[i]);
                generatePermutation(nums, index + 1, p);
                p.removeLast();
                used[i]  = false;

            }
        }

        return;
    }

}

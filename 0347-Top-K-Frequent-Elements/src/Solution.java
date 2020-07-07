import javafx.util.Pair;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * 时间复杂度: O(nlogk)
 * 空间复杂度: O(n + k)
 *
 * @author : lichao
 * @date : 2020/7/3 11:01 上午
 */

public class Solution {

    private class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            if (o1.getKey() != o2.getKey()) {
                return o1.getKey() - o2.getKey();
            }
            return o1.getValue() - o2.getValue();
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k should be greater than 0");
        }

        // 统计每个元素出现的频率
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }

        if (k > freq.size()) {
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");
        }

        // 扫描 freq ，维护当前出现频率最高的 K 个元素
        // 在优先队列中，按照频率排序，所以数据对是（频率，元素）的形式
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new PairComparator());
        for (Integer num : freq.keySet()) {
            int numFreq = freq.get(num);
            if (pq.size() == k) {
                if (numFreq > pq.peek().getKey()) {
                    pq.poll();
                    pq.add(new Pair<>(numFreq, num));
                }
            } else {
                pq.add(new Pair<>(numFreq, num));
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        while(!pq.isEmpty()) {
            res.add(pq.poll().getValue());
        }
        int[] re = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            re[i] = res.get(i);
        }
        return re;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = (new Solution()).topKFrequent(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

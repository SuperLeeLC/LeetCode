import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * 二叉树的层序遍历
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(n)
 *
 * @author : lichao
 * @date : 2020/7/2 4:56 下午
 */

public class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 使用 LinkedList 作为先入先出的队列
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(root, 0));

        while (!queue.isEmpty()) {

            Pair<TreeNode, Integer> front = queue.removeFirst();
            TreeNode node = front.getKey();
            int level = front.getValue();

            if (level == res.size()) {
                res.add(new ArrayList<>());
            }
            assert level < res.size();

            res.get(level).add(node.val);
            if (node.left != null) {
                queue.addLast(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.addLast(new Pair<>(node.right, level + 1));
            }
        }
        return res;
    }

}

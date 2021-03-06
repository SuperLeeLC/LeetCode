/**
 * @author : lichao
 * @date : 2020/7/3 9:55 下午
 */

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 在以 root 为根节点的二叉树中，寻找和为 sum 的路径，返回这样的路径个数
    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    // 在以 node 为根节点的二叉树中，寻找包含 node 的路径，和为 sum
    // 返回这样的路径个数
    private int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        int res = 0;
        if (node.val == sum) {
            res += 1;
        }

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);

        return res;
    }

}

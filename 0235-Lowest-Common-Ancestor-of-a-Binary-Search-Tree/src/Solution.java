/**
 * @author : lichao
 * @date : 2020/7/4 10:09 上午
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            throw new IllegalArgumentException(" p or q can not be null.");
        }

        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

}

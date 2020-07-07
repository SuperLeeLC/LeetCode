import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * 二叉树的后序遍历
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(h), h为树的高度
 *
 * @author : lichao
 * @date : 2020/7/2 4:31 下午
 */

public class Solution1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    public void postorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            postorderTraversal(node.left, list);
            postorderTraversal(node.right, list);
            list.add(node.val);
        }
    }

}

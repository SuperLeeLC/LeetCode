import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * 二叉树的前序遍历
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(h), h为树的高度
 *
 * @author : lichao
 * @date : 2020/7/2 3:52 下午
 */

public class Solution1 {

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
    }

}

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lichao
 * @date : 2020/7/3 8:58 下午
 */

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        for (int i = 0; i < leftPaths.size(); i++) {
            res.add(Integer.toString(root.val) + "->" + leftPaths.get(i));
        }

        List<String> rightPaths = binaryTreePaths(root.right);
        for (int i = 0; i < rightPaths.size(); i++) {
            res.add(Integer.toString(root.val) + "->" + rightPaths.get(i));
        }

        return res;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> res = new Solution().binaryTreePaths(root);
        System.out.println(res);
    }

}

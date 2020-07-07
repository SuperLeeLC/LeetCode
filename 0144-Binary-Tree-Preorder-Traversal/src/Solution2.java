import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * 二叉树的前序遍历
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(h), h为树的高度
 *
 * @author : lichao
 * @date : 2020/7/2 3:01 下午
 */

public class Solution2 {

    private class Command{
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));

        while (!stack.empty()) {
            Command command = stack.pop();

            if (command.s.equals("print")) {
                res.add(command.node.val);
            } else {
                assert command.s.equals("go");
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
                stack.push(new Command("print", command.node));
            }
        }

        return res;
    }

}

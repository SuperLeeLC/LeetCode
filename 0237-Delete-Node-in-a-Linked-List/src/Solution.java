/**
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * 时间复杂度: O(1)
 * 空间复杂度: O(1)
 *
 * @author : lichao
 * @date : 2020/7/2 10:52 上午
 */

public class Solution {

    public void deleteNode(ListNode node) {

        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Node should be valid and can not be tail node.");
        }

        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
    }

}

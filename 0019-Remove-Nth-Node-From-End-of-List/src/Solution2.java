/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * 使用双指针, 对链表只遍历了一遍
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author : lichao
 * @date : 2020/7/2 11:09 上午
 */

public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            assert q != null;
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        ListNode delNode = p.next;
        p.next = delNode.next;

        return dummyHead.next;
    }

}

/**
 *  206. Reverse Linked List
 *  https://leetcode.com/problems/reverse-linked-list/description/
 *
 *  递归的方式反转链表
 *  时间复杂度: O(n)
 *  空间复杂度: O(n) - 注意，递归是占用空间的，占用空间的大小和递归深度成正比：）
 *
 * @author : lichao
 * @date : 2020/7/1 9:14 下午
 */

public class Solution2 {

    public ListNode reverseList(ListNode head) {

        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rhead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return rhead;

    }

}

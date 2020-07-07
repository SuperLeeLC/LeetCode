/**
 *
 *  206. Reverse Linked List
 *  https://leetcode.com/problems/reverse-linked-list/description/
 *  时间复杂度: O(n)
 *  空间复杂度: O(1)
 *
 * @author : lichao
 * @date : 2020/7/1 8:47 下午
 */

public class Solution1 {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode head2 = new Solution1().reverseList(head);
        System.out.println(head2);
    }

}
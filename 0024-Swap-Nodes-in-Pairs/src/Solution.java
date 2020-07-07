/**
 * @author : lichao
 * @date : 2020/7/2 10:31 上午
 */

public class Solution {

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution()).swapPairs(head);
        System.out.println(head);
    }
}

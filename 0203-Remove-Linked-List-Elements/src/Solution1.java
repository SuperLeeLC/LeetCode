/**
 * @author : lichao
 * @date : 2020/7/2 10:12 上午
 */

public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {

        // 对头结点进行特殊处理
        while (head != null && head.val == val) {
            ListNode node = head;
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;

        ListNode head = new ListNode(arr);
        System.out.println(head);

        (new Solution1()).removeElements(head, val);
        System.out.println(head);
    }

}

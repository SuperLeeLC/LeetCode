/**
 * @author : lichao
 * @date : 2020/7/2 10:12 上午
 */

public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        // 创建虚拟头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;

        ListNode head = new ListNode(arr);
        System.out.println(head);

        (new Solution2()).removeElements(head, val);
        System.out.println(head);
    }

}

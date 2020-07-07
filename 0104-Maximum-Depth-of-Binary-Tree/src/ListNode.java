/**
 * Definition for singly-linked list.
 *
 * @author : lichao
 * @date : 2020/7/1 8:47 下午
 */

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 根据n个元素的数组arr创建一个链表
     * 使用arr为参数，创建另外一个ListNode的构造函数
     *
     * @param arr
     */
    ListNode(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(" Arr can not be empty");
        }

        this.val = arr[0];
        ListNode curNode = this;

        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    /**
     * 返回以当前ListNode为头结点的链表信息字符串
     *
     * @return
     */
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder("");
        ListNode curNode = this;
        while (curNode != null) {
            s.append(Integer.toString(curNode.val));
            s.append(" -> ");
            curNode = curNode.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
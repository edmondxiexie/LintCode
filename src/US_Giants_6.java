/**
 * Created by Edmond on 10/31/16.
 */
public class US_Giants_6 {
    /**
     * 96. Partition List.
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode small = dummy;
        ListNode big = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {

                big.next = next;
                cur.next = small.next;
                small.next = cur;
                small = small.next;

            } else {
                if (big == null) {
                    big = cur;
                } else {
                    big = big.next;
                    System.out.println(big.val);
                }
            }
            cur = next;
        }
        return dummy.next;
    }
}

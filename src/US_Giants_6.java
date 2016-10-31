/**
 * Created by Edmond on 10/31/16.
 */
public class US_Giants_6 {
    /**
     * 96. Partition List.
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return a ListNode
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode small = dummy;
        ListNode big = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                if (big == null) {
                    small = small.next;
                } else {
                    big.next = next;
                    cur.next = small.next;
                    small.next = cur;
                    small = small.next;
                }
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

    /**
     * 35. Reverse Linked List.
     * @param head: The head of linked list.
     * @return The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        ListNode cur = partition(a, 3);
    }


}

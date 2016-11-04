import java.util.*;

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

    /**
     * 106. Convert Sorted List to Balanced BST.
     * @param head: The first node of linked list.
     * @return a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = dummy;
        while (fast.next != null && fast.next.next != null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (last != dummy) {
            last.next = null;
            ListNode left = dummy.next;
            root.left = sortedListToBST(left);
        }
        if (slow.next != null) {
            ListNode right = slow.next;
            slow.next = null;
            root.right = sortedListToBST(right);
        }
        return root;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 105. Copy List with Random Pointer.
     * @param head: The head of linked list with a random pointer.
     * @return A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        while (head != null) {
            map.put(head, new RandomListNode(head.label));
            head = head.next;
        }
        head = dummy.next;
        RandomListNode newDummy = new RandomListNode(0);
        newDummy.next = map.get(head);
        while (head != null) {
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }
        return newDummy.next;
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

/**
 *  two pointers a, b
 *  a is n steps ahead of b
 *
*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode r = s.removeNthFromEnd(n1, 3);

        while ( r!=null ) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode a = head, b = head;

        int i = n;
        while (i!=0) {
            a = a.next;
            i -= 1;
        }

        if (a==null) {
            return head.next;
        }

        while ( a.next != null ) {
            a = a.next;
            b = b.next;
        }

        b.next = b.next.next;
        return head;
    }
}

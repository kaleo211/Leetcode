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
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        // n1.next = n2;
        // n2.next = n3;
        // n3.next = n4;
        // n4.next = n5;
        // n5.next = n6;

        ListNode r = s.removeElements(null, 1);
        while (r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }


    public ListNode removeElements(ListNode head, int val) {

        ListNode tmp_head = new ListNode(0);
        tmp_head.next = head;
        ListNode tmp = tmp_head;
        while (tmp.next!=null) {
            if (tmp.next.val==val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }

        return tmp_head.next;
    }
}

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
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        // n1.next = n2;
        // n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode r = s.deleteDuplicates(n1);

        while (r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head==null || head.next==null) {
            return head;
        }

        ListNode pre = head;
        ListNode tmp = head.next;

        while (tmp!=null) {
            if (tmp.val!=pre.val) {
                pre.next = tmp;
                pre =tmp;
            }
            tmp = tmp.next;
        }

        if (tmp!=pre) {
            pre.next = null;
        }

        return head;
    }
}

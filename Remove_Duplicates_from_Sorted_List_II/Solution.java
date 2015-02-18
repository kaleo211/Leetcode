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
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode r = s.deleteDuplicates(n1);

        while (r!=null) {
            System.out.print(r.val +" -> ");
            r = r.next;
        }
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head==null || head.next==null) {
            return head;
        }

        ListNode new_head = new ListNode(Integer.MIN_VALUE);
        ListNode pre = new_head;
        new_head.next = null;

        ListNode last_head = new ListNode(Integer.MIN_VALUE);
        last_head.next = head;
        ListNode tmp = head, last = last_head;

        while (tmp!=null) {
            if (tmp.val!=last.val && (tmp.next==null || tmp.next.val!=tmp.val)) {
                System.out.println("pre: "+pre.val+" tmp: "+tmp.val);
                pre.next = tmp;
                pre =tmp;
            } else if (tmp.next!=null && tmp.next.val==tmp.val) {
                System.out.println(" next: "+tmp.next.val);
                tmp = tmp.next;
                last = last.next;
            }
            last = last.next;
            tmp = tmp.next;
        }

        if (tmp!=pre) {
            pre.next = null;
        }

        return new_head.next;
    }
}


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
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        // n3.next = n4;
        n4.next = n5;

        ListNode r = s.rotateRight(n1, 2);
        while (r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null) {
            return head;
        }

        ListNode tmp = head, tail = head;

        int len = 0;
        while (tmp!=null) {
            tmp = tmp.next;
            len += 1;
        }
        k %= len;

        if (k==0) {
            return head;
        }

        tmp = head;
        while(k>0) {
            k -= 1;
            tmp = tmp.next;
        }

        while (tmp.next!=null) {
            tail = tail.next;
            tmp = tmp.next;
        }

        ListNode new_head = tail.next;
        tail.next = null;
        tmp.next = head;

        return new_head;
    }
}

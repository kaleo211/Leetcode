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
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode r = new Solution().reverseKGroup(n1, 6);
        while (r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (k<2 || head==null) {
            return head;
        }

        ListNode tail = head, tmp = head;

        int kk = k-1;

        while (kk>0) {
            tmp = tmp.next;
            if (tmp==null) {
                return head;
            }
            kk -= 1;
        }

        ListNode rest = tmp.next;
        ListNode pre = rest;
        tmp = head;

        kk = k;
        while (kk>0) {
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
            kk -= 1;
        }
        tail.next = reverseKGroup(rest, k);
        ListNode new_head = pre;

        return new_head;
    }
}

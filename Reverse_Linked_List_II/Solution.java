public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null || m==n)
            return head;

        ListNode new_head = new ListNode(0);
        new_head.next = head;

        ListNode tmp = head, start = new_head, pre = new_head;
        int index = 1;

        while (tmp!=null) {
            if (index>m && index<n) {

            } else if (index==m) {
                end = tmp;
                tmp = tmp.next;
            } else if (index==n) {

            } else {

            }
        }
    }
}

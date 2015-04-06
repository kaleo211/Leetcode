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
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode r = s.reverseBetween(n1, 5, 5);
        while (r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m>=n) {
            return head;
        }

        ListNode nh = new ListNode(0);
        nh.next = head;

        ListNode tmp = nh;
        ListNode tail=null, front=null, tt=null;

        int k = 0;
        while (true) {
            if (k<m-1) {
                k += 1;
                tmp = tmp.next;

            } else if (k==m-1) {
                tt = tmp;
                tail = tmp.next;
                front = tmp.next;
                tmp = tmp.next.next;
                k += 2;

            } else if (k>m-1 && k<n) {
                ListNode t = tmp;
                tmp = tmp.next;
                k += 1;
                t.next = front;
                front = t;

            } else if (k==n) {
                tail.next = tmp.next;
                tmp.next = front;
                tt.next = tmp;
                break;
            }
        }

        return nh.next;
    }
}

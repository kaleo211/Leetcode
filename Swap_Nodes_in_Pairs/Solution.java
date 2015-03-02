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
        n3.next = n4;
        n4.next = n5;

        ListNode r = s.swapPairs(n1);
        while (r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if (head==null || head.next==null) {
            return head;
        }

        ListNode cur = head, pre = head;
        ListNode new_head = head.next;

        // start from the 2nd node
        boolean odd = true;
        while (cur!=null) {
            ListNode tmp = cur;
            cur = cur.next;

            if (odd) {
                if (tmp.next!=null && tmp.next.next!=null) {
                    if (tmp.next.next.next!=null) {
                        tmp.next = tmp.next.next.next;
                    } else {
                        tmp.next = tmp.next.next;
                    }
                } else if (tmp.next!=null && tmp.next.next==null) {
                    tmp.next = null;
                }
                pre = tmp;
                odd = false;
            } else {
                tmp.next = pre;
                odd = true;
            }
        }

        return new_head;
    }
}

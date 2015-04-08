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
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode r = s.insertionSortList(n1);
        while (r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }


    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }

        ListNode sorted = head;
        ListNode unsorted = head.next;
        sorted.next = null;

        while (unsorted!=null) {
            ListNode tmp = unsorted;
            unsorted = unsorted.next;
            ListNode t = sorted;

            if (tmp.val<t.val) {
                tmp.next = sorted;
                sorted = tmp;
            } else {
                while (t!=null) {
                    if (tmp.val==t.val || tmp.val>t.val && (t.next==null || tmp.val<t.next.val)) {
                        tmp.next = t.next;
                        t.next = tmp;
                        break;
                    }
                    t = t.next;
                }
            }
        }
        return sorted;
    }
}

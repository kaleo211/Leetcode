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
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        // n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode r = s.mergeTwoLists(n1, n4);
        while (r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }


    private ListNode list1=null, list2=null;

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        list1 = l1;
        list2 = l2;

        ListNode head = merge();
        ListNode tmp = head;
        while (tmp!=null) {
            tmp.next = merge();
            tmp = tmp.next;
        }

        return head;
    }

    private ListNode merge() {
        ListNode r = null;
        if (list2==null || list1!=null && list2!=null && list1.val<list2.val) {
            r = list1;
            if (list1!=null) {
                list1 = list1.next;
            }
        } else {
            r = list2;
            if (list2!=null) {
                list2 = list2.next;
            }
        }
        return r;
    }
}

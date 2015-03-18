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
        n2.next = n6;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode r = s.getIntersectionNode(n1, n3);
        while (r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = 0, lb = 0;

        ListNode tmp = headA;
        while (tmp!=null) {
            la += 1;
            tmp = tmp.next;
        }

        tmp = headB;
        while (tmp!=null) {
            lb += 1;
            tmp = tmp.next;
        }

        ListNode a = null, b = null;
        int c = 0;
        if (la>lb) {
            c = la - lb;
            a = headA;
            b = headB;
        } else {
            c = lb - la;
            a = headB;
            b = headA;
        }

        while (c>0) {
            a = a.next;
            c -= 1;
        }

        while (a!=null) {
            if (a==b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }

        return null;
    }
}

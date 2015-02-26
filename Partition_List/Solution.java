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
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode r = s.partition(n1, 3);
        while (r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode tmp = head;
        int size = 0;
        while (tmp!=null) {
            size+=1;
            tmp = tmp.next;
        }

        int[] bigger = new int[size];
        int[] smaller = new int[size];
        int b=0, s=0;

        tmp = head;
        while (tmp!=null) {
            if (tmp.val>=x) {
                bigger[b] = tmp.val;
                b += 1;
            } else {
                smaller[s] = tmp.val;
                s += 1;
            }
            tmp = tmp.next;
        }
        for (int i=0; i<b; i+=1) {
            smaller[s+i] = bigger[i];
        }

        tmp = head;
        s = 0;
        while (tmp!=null) {
            tmp.val = smaller[s];
            s += 1;
            tmp = tmp.next;
        }

        return head;
    }
}

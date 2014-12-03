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
        n1.next = n2;
        n2.next = n3;
        n3.next = n2;
        System.out.println("cycle? "+s.detectCycle(n1).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head==null)
            return null;
        ListNode fast = head, slow = head;
        boolean cycle = false;

        while (fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                cycle = true;
                break;
            }
        }

        if (cycle) {
            fast = head;
            while (fast!=slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        } else {
            return null;
        }
    }
}

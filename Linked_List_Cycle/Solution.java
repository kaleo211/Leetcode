
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
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        n2.next = n1;
        System.out.println("cycle? "+s.hasCycle(n1));
    }

    public boolean hasCycle(ListNode head) {
        if (head==null)
            return false;
        ListNode fast = head, slow = head;

        while (fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow)
                return true;
        }
        return false;
    }
}

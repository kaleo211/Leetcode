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
        // n2.next = n3;
        n3.next = n4;
        // n4.next = n5;
        // n5.next = n6;

        s.reorderList(null);
        while (n1!=null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null) {
            return;
        }

        ListNode slow = head, fast = head;

        int l1=0, l2=0, len=0;

        while (true) {
            if (fast==null) {
                l1 -= 2;
                break;
            }
            if (fast.next==null) {
                l1 -= 1;
                break;
            }
            slow = slow.next;
            l1 += 1;
            fast = fast.next.next;
        }
        // 1->2->3          => 1->2  & 3       => 1->3->2
        // 1->2->3->4    => 1->2->3  & 4  =>  1->4->2->3
        ListNode tmp = slow;
        slow = slow.next;
        tmp.next = null;

        while (slow!=null) {
            ListNode cur = slow;
            tmp = head;
            slow = slow.next;
            int count = l1;
            l1 -= 1;
            while (count!=0) {
                count -= 1;
                tmp = tmp.next;
            }

            cur.next = tmp.next;
            tmp.next = cur;
        }
    }
}

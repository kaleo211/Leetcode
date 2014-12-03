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
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(9);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(9);
        ListNode n11 = new ListNode(9);
        // n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        ListNode result = s.addTwoNumbers(n1, n2);
        while (result!=null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode tmp = l1;
        long n1 = 0, n2 = 0;
        int len1=0, len2=0;
        long b = 1;
        while (tmp!=null) {
            n1 += tmp.val*b;
            b *= 10;
            tmp = tmp.next;
            len1 += 1;
        }

        tmp = l2;
        b = 1;
        while (tmp!=null) {
            n2 +=  tmp.val*b;
            b *= 10;
            tmp = tmp.next;
            len2 = 0;
        }
        ListNode result = new ListNode(0);
        ListNode cur = result;
        result.next = l1;
        if (len2>len1)
            result.next = l2;

        char[] number = String.valueOf(n1 + n2).toCharArray();
        int length = number.length;
        for (int i=0; i<length; i++) {
            int bit = Integer.valueOf(number[length-i-1]-48);
            if (cur.next!=null) {
                cur.next.val = bit;
            } else {
                cur.next = new ListNode(bit);
            }
            cur = cur.next;
        }
        return result.next;
    }
}

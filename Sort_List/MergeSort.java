/*
 * kaleo211
 * Xuebin He
 * hexuebin0201@gmail.com
 */

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class MergeSort {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode tmp = s.sortList(n1);
        while (tmp!=null) {
            System.out.println("dfsafsa "+tmp.val);
            tmp = tmp.next;
        }
    }

    public ListNode sortList(ListNode head) {
        return mergesort(head);
    }

    private ListNode mergesort(ListNode list) {
        if (list==null || list.next==null)
            return list;

        ListNode l=list, r=list;
        while (r.next!=null && r.next.next!=null) {
            r = r.next.next;
            l = l.next;
        }
        r = l.next;
        l.next = null;

        return merge( mergesort(list), mergesort(r));
    }

    private ListNode merge(ListNode l, ListNode r) {
        if (l==null) {
            return r;
        } else if (r==null) {
            return l;
        }

        ListNode head = null, tail = null;
        if (l.val<r.val) {
            head = l;
            l = l.next;
        } else {
            head = r;
            r = r.next;
        }
        tail = head;

        while (l!=null && r!=null) {
            if ( r.val<l.val ) {
                tail.next = r;
                r = r.next;
            } else {
                tail.next = l;
                l = l.next;
            }
            tail = tail.next;
        }

        if (l!=null) {
            tail.next = l;
        } else if (r!=null) {
            tail.next = r;
        }

        return head;
    }
}

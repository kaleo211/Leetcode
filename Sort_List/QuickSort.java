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

public class QuickSort {

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
        int count = 0;
        ArrayList<ListNode> array = new ArrayList<ListNode>();
        ListNode tmp = head;
        while (tmp!=null) {
            array.add(count, tmp);
            count += 1;
            tmp = tmp.next;
        }
        if (count>0) {
            quicksort(array, 0, count-1);
            return array.get(0);
        } else {
            return null;
        }
    }

    private void quicksort(ArrayList<ListNode> array, int low, int high) {
        if (low>=high) return;
        int key = array.get(low).val;
        int i=low, j=high;
        while (i<j) {
            while (i<j && array.get(j).val>=key)
                j -= 1;
            if (i<j)  {
                swap(array, i, j);
                i += 1;
            }
            while (i<j && array.get(i).val<=key)
                i += 1;
            if (i<j) {
                swap(array, i, j);
                j -= 1;
            }
        }
        if (i>low)
            quicksort(array, low, j-1);
        if (j<high)
            quicksort(array, i+1, high);
    }

    private void swap(ArrayList<ListNode> array, int i, int j) {
        int tmp = array.get(i).val;
        array.get(i).val = array.get(j).val;
        array.get(j).val = tmp;
    }
}

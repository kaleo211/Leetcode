import java.util.ArrayList;
import java.util.List;

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
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n3.next = n4;
        n5.next = n6;
        n6.next = n7;
        List<ListNode> l = new ArrayList<ListNode>();
        // l.add(null);
        // l.add(n3);
        // l.add(n5);
        ListNode r = s.mergeKLists(l);
        while(r!=null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        int k = lists.size();
        if (k==0) {
            return null;
        }else if (k==1) {
            return lists.get(0);
        } else {
            int split = k/2;

            List<ListNode> list1 = new ArrayList<ListNode>();
            for (int i=0; i<split; i+=1) {
                list1.add(lists.get(i));
            }
            List<ListNode> list2 = new ArrayList<ListNode>();
            for (int i=split; i<k; i+=1) {
                list2.add(lists.get(i));
            }
            return merge(mergeKLists(list1), mergeKLists(list2));

        }
    }

    public ListNode merge(ListNode l1, ListNode l2) {

        if (l1==null) return l2;
        if (l2==null) return l1;

        ListNode head;
        if (l1.val>l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }
        ListNode tmp = head;

        while (l1!=null && l2!=null) {
            if (l1.val>l2.val) {
                tmp.next = l2;
                l2 = l2.next;
            } else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }

        if (l1!=null)
            tmp.next = l1;
        if (l2!=null)
            tmp.next = l2;

        return head;
    }
}

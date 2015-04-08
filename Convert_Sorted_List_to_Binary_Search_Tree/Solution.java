
import java.util.ArrayList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

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
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        TreeNode r = s.sortedListToBST(n1);
        s.print(r);
    }

    private void print(TreeNode root) {
        if (root==null) {
            return;
        }
        System.out.println("val: "+root.val);
        print(root.left);
        print(root.right);
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while (head!=null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(list.toArray(new Integer[]{}));
    }

    public TreeNode sortedArrayToBST(Integer[] num) {
        return convert(num, 0, num.length-1);
    }

    private TreeNode convert(Integer[] A, int low, int high) {
        if (low>high) {
            return null;
        }
        int mid = (low+high)/2;
        TreeNode t = new TreeNode(A[mid]);
        t.left = convert(A, low, mid-1);
        t.right = convert(A, mid+1, high);
        return t;
    }
}

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

public class Solution {



    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        List<List<Integer>> list = new Solution().levelOrderBottom(t1);
        for (List<Integer> l: list) {
            for (Integer i: l) {
                System.out.print(i+", ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> list = null;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        list = new ArrayList<List<Integer>>();
        traversal(root, 0);
        List<List<Integer>> n = new ArrayList<List<Integer>>();
        for (List<Integer> l: list) {
            n.add(0, l);
        }
        return n;
    }

    private void traversal(TreeNode t, int level) {
        if (t==null) {
            return;
        }

        List<Integer> l = null;
        if (list.size()<level+1) {
            l = new ArrayList<Integer>();
            list.add(l);
        } else {
            l = list.get(level);
        }
        l.add(t.val);
        traversal(t.left, level+1);
        traversal(t.right, level+1);
    }
}

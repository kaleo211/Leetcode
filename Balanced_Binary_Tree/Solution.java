import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

public class Solution {

    private Map<TreeNode, Integer> dep = null;
    private int max = 0;

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.right=t2;
        t2.right=t3;

        System.out.println(s.isBalanced(t1));
    }

    private int depth(TreeNode t) {
        if (t!=null) {
            int ld = depth(t.left), rd = depth(t.right);
            int d = (ld>rd ? ld : rd) + 1;
            dep.put(t, d);
            return d;

        } else {
            return 0;
        }
    }

    public boolean isBalanced(TreeNode root) {
        dep = new HashMap<TreeNode, Integer>();
        depth(root);

        return balance(root);
    }

    private boolean balance(TreeNode t) {
        if (t!=null) {
            if (t.left==null ) {
                if (t.right==null || dep.get(t.right) ==1) {
                    return true;
                }
                return false;

            } else if (t.right==null)  {
                if (dep.get(t.left)==1) {
                    return true;
                }
                return false;

            } else if (Math.abs(dep.get(t.left)-dep.get(t.right))>1) {
                return false;

            } else {
                return balance(t.right) && balance(t.left);
            }
        } else {
            return true;
        }
    }
}

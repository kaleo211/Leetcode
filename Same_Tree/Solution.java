
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(1);
        n1.left=null;n1.right=null;
        TreeNode n2 = new TreeNode(1);
        n2.left=n1;n2.right=null;
        System.out.println("same? " + s.isSameTree(n1, n2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        if (p!=null && q!=null) {
            if (p.val!=q.val)
                return false;
            boolean right = (p.right==null && q.right==null || p.right!=null && q.right!=null);
            boolean left = (p.left==null && q.left==null || p.left!=null && q.left!=null);
            if (right && left)
                return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
            return false;
        }
        return false;
    }
}

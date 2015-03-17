class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}


public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        return symmectric(root.right, root.left);
    }

    private boolean symmectric(TreeNode r, TreeNode l) {
        if (r==null && l==null) {
            return true;
        }
        if (r==null || l==null || r.val!=l.val) {
            return false;
        }

        return symmectric(r.right, l.left) && symmectric(r.left, l.right);
    }
}

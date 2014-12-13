class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode l = new TreeNode(1);
        System.out.println(new Solution().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        long min = (long)Integer.MIN_VALUE-1;
        long max = (long)Integer.MAX_VALUE+1;
        return valid(root, min, max);
    }

    private boolean valid(TreeNode t, long min, long max) {
        if (t!=null) {
            long val = (long) t.val;
            if (val>= max || val<= min) {
                return false;
            }
            return valid(t.left, min, val) && valid(t.right, val, max);
        }
        return true;
    }
}

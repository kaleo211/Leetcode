 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() { val = 1; left=null; right=null;}
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        n1.right = n2;
        System.out.println(s.hasPathSum(n1, 1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root!=null) {
            int sub = sum-root.val;
            if (sub==0 && root.left==null && root.right==null)
                return true;
            return hasPathSum(root.left, sub) || hasPathSum(root.right, sub);
        }
        return false;
    }
}

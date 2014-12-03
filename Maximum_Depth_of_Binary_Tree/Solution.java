

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    int depth;


    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(1);
        n1.left=null;n1.right=null;
        TreeNode n2 = new TreeNode(1);
        n2.left=n1;n2.right=null;
        TreeNode n3 = new TreeNode(1);
        n3.left=n2;n3.right=null;
        System.out.println(s.maxDepth(n3));
    }

    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        depth = 0;
        dfs(root, 1);
        return depth;
    }

    public void dfs(TreeNode t, int cur) {
        if (cur>depth) {
            depth = cur;
        }
        if (t.left!=null)
            dfs(t.left, cur+1);
        if (t.right!=null)
            dfs(t.right, cur+1);
        return;
    }
}

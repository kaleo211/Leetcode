import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        List<Integer> r = s.postorderTraversal(t1);
        for(Integer i: r) {
            System.out.println(i);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(root, list);
        return list;
    }

    public void dfs(TreeNode t, List<Integer> list) {
        if (t!=null) {
            dfs(t.left, list);
            dfs(t.right, list);
            list.add(t.val);
        }
    }
}

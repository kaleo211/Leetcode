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
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        List<List<Integer>> r = s.pathSum(n1, 8);
        for (List<Integer> p: r)  {
            for (int i: p)
                System.out.print(i+",");
            System.out.println();
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> paths = new ArrayList<List<Integer>>();
        dfs(root, sum, new ArrayList<Integer>(), paths);
        return paths;
    }

    public void dfs(TreeNode t, int sum, ArrayList<Integer> path, ArrayList<List<Integer>> paths) {
        if (t!=null) {
            int sub = sum-t.val;
            path.add(t.val);
            if (sub==0 && t.right==null && t.left==null) {
                paths.add(new ArrayList<Integer>(path));
            }
            dfs(t.left, sub, new ArrayList<Integer>(path), paths);
            dfs(t.right, sub, new ArrayList<Integer>(path), paths);
        }
    }
}

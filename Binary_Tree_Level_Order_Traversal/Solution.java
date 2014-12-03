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
        t1.left = t3;
        List<List<Integer>> r = s.levelOrder(t1);
        for(List<Integer> l: r) {
            for(Integer i: l)
                System.out.print(i+" ");
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        dfs(root, 0, list);
        return list;
    }

    public void dfs(TreeNode t, int deep, List<List<Integer>> list) {
        if (t!=null) {
            if (list.size()==deep)
                list.add(new ArrayList<Integer>());
            list.get(deep).add(t.val);
            dfs(t.left, deep+1, list);
            dfs(t.right, deep+1, list);
        }
    }
}

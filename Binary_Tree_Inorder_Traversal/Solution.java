import java.util.List;
import java.util.ArrayList;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(root, list);
        return list;
    }

    public void dfs(TreeNode t, List<Integer> list) {
        if (t!=null) {
            dfs(t.left, list);
            list.add(t.val);
            dfs(t.right, list);
        }
    }
}

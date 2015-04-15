import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root==null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        queue.add(root);
        map.put(root, root.val);

        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            int val = map.get(t);
            if (t.left==null && t.right==null) {
                sum += val;
            } else {
                if (t.left!=null) {
                    queue.add(t.left);
                    map.put(t.left, t.left.val+val*10);
                }
                if (t.right!=null) {
                    queue.add(t.right);
                    map.put(t.right, t.right.val+val*10);
                }
            }
        }

        return sum;
    }
}

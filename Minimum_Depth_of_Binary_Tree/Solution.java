import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        r1.right = r2;
        r1.left = r3;
        System.out.println(s.minDepth(r1));
    }

    public int minDepth(TreeNode root) {

        if (root==null)
            return 0;

        LinkedList<TreeNode> t = new LinkedList<TreeNode>();
        t.add(root);
        LinkedList<Integer> d = new LinkedList<Integer>();
        d.add(1);

        while (true) {
            TreeNode cur_node = t.poll();
            int cur_depth = d.poll();
            if (cur_node.left==null && cur_node.right==null) {
                return cur_depth;
            }
            if (cur_node.left!=null) {
                t.add(cur_node.left);
                d.add(cur_depth+1);
            }
            if (cur_node.right!=null) {
                t.add(cur_node.right);
                d.add(cur_depth+1);
            }
        }
    }
}

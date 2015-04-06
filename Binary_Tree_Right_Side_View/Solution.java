import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

public class Solution {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.right = t3;
        t1.left = t2;
        t3.right = t4;
        t2.right = t5;
        t5.right = t6;

        List<Integer> list = new Solution().rightSideView(t1);

        for (Integer i: list) {
            System.out.print(i+", ");
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root==null) {
            return list;
        }


        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> level = new HashMap<TreeNode, Integer>();

        queue.add(root);
        level.put(root, 1);
        int l = 0;
        while (queue.size()>0) {
            TreeNode t = queue.poll();
            if (level.get(t)!=l) {
                l = level.get(t);
                list.add(t.val);
            }
            if (t.right!=null) {
                queue.add(t.right);
                level.put(t.right, l+1);
            }
            if (t.left!=null) {
                queue.add(t.left);
                level.put(t.left, l+1);
            }
        }

        return list;
    }
}

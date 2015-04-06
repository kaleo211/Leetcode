import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

public class Solution {


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        List<List<Integer>> r = new Solution().zigzagLevelOrder(t1);

        for (List<Integer> l: r) {
            for (Integer i: l) {
                System.out.print(i+", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root==null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, 1);

        int pre = 0, level = 0;

        List<Integer> r = new ArrayList<Integer>();

        while (queue.size()>0) {
            TreeNode t = queue.poll();
            level = map.get(t);
            if (level!=pre) {
                pre = level;
                if (level%2==1) {
                    Collections.reverse(r);
                }
                result.add(r);

                r = new ArrayList<Integer>();
                r.add(t.val);

            } else {
                r.add(t.val);
            }

            if (t.left!=null) {
                queue.add(t.left);
                map.put(t.left, level+1);
            }
            if (t.right!=null) {
                queue.add(t.right);
                map.put(t.right, level+1);
            }
        }

        if (level%2==0) {
            Collections.reverse(r);
        }
        result.add(r);
        result.remove(0);

        return result;
    }
}

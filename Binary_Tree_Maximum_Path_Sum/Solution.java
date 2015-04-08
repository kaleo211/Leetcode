class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}


public class Solution {

    int max = Integer.MIN_VALUE;


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-9);
        TreeNode t2 = new TreeNode(-1);
        TreeNode t3 = new TreeNode(-2);
        TreeNode t4 = new TreeNode(-6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(-6);
        TreeNode t8 = new TreeNode(-6);
        TreeNode t9 = new TreeNode(-6);
        t1.left = t2;
        t1.right = t3;
        // t3.left = t4;
        // t3.right = t5;
        // t5.left = t6;
        // t6.left = t7;
        // t6.right = t8;
        // t7.left = t9;

        System.out.println(new Solution().maxPathSum(t1));
    }



    public int maxPathSum(TreeNode root) {
        max(root);
        if (max==Integer.MIN_VALUE) {
            return 0;
        }
        return max;
    }

    private int max(TreeNode node) {
        if (node==null) {
            return -1;
        }

        int left = max(node.left);
        int right = max(node.right);

        if (left<0 && right<0) {
            if (node.val>max) {
                max = node.val;
            }
            if (node.val<0) {
                return 0;
            }
            return node.val;
        }

        int larger = left>right?left:right;

        if (node.val+left+right>max) {
            max = node.val+left+right;
        }
        if (node.val+larger>max) {
            max = node.val+larger;
        }
        if (node.val>max) {
            max = node.val;
        }

        return larger+node.val;
    }
}

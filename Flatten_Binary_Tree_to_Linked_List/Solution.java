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
        // t1.right = t5;
        // t1.left = t2;
        // t2.left = t3;
        // t2.right = t4;
        // t5.right = t6;

        new Solution().flatten(null);
        new Solution().print(t1);
    }

    private void print(TreeNode root) {
        if (root==null) {
            return;
        }
        System.out.println("val: "+root.val);
        print(root.left);
        print(root.right);
    }

    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        traverse(root);
    }

    private TreeNode traverse(TreeNode node) {
        if (node.left==null && node.right==null) {
            return node;
        }
        TreeNode tmp = null;
        if (node.left!=null) {
            tmp = traverse(node.left);
            tmp.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        if (node.right!=null) {
            tmp = traverse(node.right);
        }
        return tmp;
    }
}

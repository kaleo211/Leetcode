class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

public class Solution {

    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,5,6};
        TreeNode r = new Solution().sortedArrayToBST(A);
        new Solution().print(r);
    }

    private void print(TreeNode root) {
        if (root==null) {
            return;
        }
        System.out.println("val: "+root.val);
        print(root.left);
        print(root.right);
    }

    public TreeNode sortedArrayToBST(int[] num) {
        return convert(num, 0, num.length-1);
    }

    private TreeNode convert(int[] A, int low, int high) {
        if (low>high) {
            return null;
        }
        int mid = (low+high)/2;
        TreeNode t = new TreeNode(A[mid]);
        t.left = convert(A, low, mid-1);
        t.right = convert(A, mid+1, high);
        return t;
    }
}

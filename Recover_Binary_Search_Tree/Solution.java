/**
 * in-order the tree
 */
public class Solution {

    TreeNode mistake1 = null, mistake2 = null, previous = null;

    public void recoverTree(TreeNode root) {

        search(root);

        int tmp = mistake1.val;
        mistake1.val = mistake2.val;
        mistake2.val = tmp;
    }

    private void search(TreeNode root) {
        if (root==null) {
            return;
        }

        search(root.left);

        if (previous!=null) {
            if (previous.val>root.val) {
                if (mistake1==null) {
                    mistake1 = previous;
                    mistake2 = root;
                } else {
                    mistake2 = root;
                }
            }
        }

        previous = root;
        search(root.right);
    }
}

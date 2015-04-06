import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}

public class BSTIterator {

    List<Integer> list = null;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<Integer>();
        if (root!=null) {
            iterate(root);
        }
    }

    private void iterate(TreeNode node) {
        if (node.left!=null) {
            iterate(node.left);
        }
        list.add(node.val);
        if (node.right!=null) {
            iterate(node.right);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (list.size()>0) {
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        int r = list.get(0);
        list.remove(0);
        return r;
    }
}

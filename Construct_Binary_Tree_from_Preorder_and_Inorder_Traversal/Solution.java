import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}


public class Solution {

    public static void main(String[] args) {
        int[] pre = new int[]{1,2};
        int[] in = new int[]{2,1};

        TreeNode root = new Solution().buildTree(pre, in);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            System.out.println(n.val);
            if (n.left!=null) queue.add(n.left);
            if (n.right!=null) queue.add(n.right);
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pl, int ph, int il, int ih) {
        System.out.println("left: "+ "pl: "+pl+" ph: "+ph+" il: "+il+" ih: "+ih);
        if (pl>ph || il>ih) {
            return null;
        }
        if (pl==ph || il==ih) {
            return new TreeNode(preorder[pl]);
        }
        TreeNode n = new TreeNode(preorder[pl]);

        int root = 0;
        for (int i=il; i<=ih; i+=1) {
            if (inorder[i]==preorder[pl]) {
                root = i;
                break;
            }
        }

        n.left = build(preorder, inorder, pl+1, pl+root-il, il, root-1);
        n.right = build(preorder, inorder, pl+root-il+1, ph, root+1, ih);
        return n;
    }
}

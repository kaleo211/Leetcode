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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int pl, int ph, int il, int ih) {
        System.out.println("left: "+ "pl: "+pl+" ph: "+ph+" il: "+il+" ih: "+ih);
        if (pl>ph || il>ih) {
            return null;
        }
        if (pl==ph || il==ih) {
            return new TreeNode(postorder[ph]);
        }
        TreeNode n = new TreeNode(postorder[ph]);

        int root = 0;
        for (int i=il; i<=ih; i+=1) {
            if (inorder[i]==postorder[ph]) {
                root = i;
                break;
            }
        }

        n.left = build(inorder, postorder, pl, pl+root-il-1, il, root-1);
        n.right = build(inorder, postorder, pl+root-il, ph-1, root+1, ih);
        return n;
    }
}

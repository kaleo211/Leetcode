
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; right = null; next = null; left = null;}
}

public class Solution {

    public void connect(TreeLinkNode root) {
        if (root==null) {
            return;
        }

        if (root.left==null && root.right==null) {
            root.next = null;
            return;
        }

        TreeLinkNode pre = root;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        HashMap<TreeLinkNode, Integer> map = new HashMap<TreeLinkNode, Integer>();
        map.put(root, 0);

        if (root.left!=null) {
            queue.add(root.left);
            map.put(root.left, 1);
        }
        if (root.right!=null) {
            queue.add(root.right);
            map.put(root.right, 1);
        }

        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            int deep = map.get(node);
            if (map.get(pre)==deep) {
                pre.next = node;
            } else {
                pre.next = null;
            }
            pre = node;

            if (node.left!=null) {
                queue.add(node.left);
                map.put(node.left, deep+1);
            }
            if (node.right!=null) {
                queue.add(node.right);
                map.put(node.right, deep+1);
            }

        }
    }
}

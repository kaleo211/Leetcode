import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}



public class Solution {


    public static void main(String[] args) {
        List<TreeNode> r = new Solution().generateTrees(0);
        System.out.println(r.size());
    }

    public List<TreeNode> generateTrees(int n) {

        if (n==0) {
            List<TreeNode> r = new ArrayList<TreeNode>();
            r.add(null);
            return r;
        }

        int[] nums = new int[n];
        for (int i=0; i<n; i+=1) {
            nums[i] = i+1;
        }

        return generate(nums, 0, n-1);
    }

    private List<TreeNode> generate(int[] nums, int front, int tail) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        for (int i=front; i<=tail; i+=1) {

            List<TreeNode> left = generate(nums, front, i-1);
            List<TreeNode> right = generate(nums, i+1, tail);

            int left_size = left.size(), right_size = right.size();

            if (left_size==0 && right_size==0) {
                TreeNode t = new TreeNode(nums[i]);
                list.add(t);

            } else if (left_size==0) {
                for (TreeNode r: right) {
                    TreeNode t = new TreeNode(nums[i]);
                    t.right = r;
                    list.add(t);
                }

            } else if (right_size==0) {
                for (TreeNode l: left) {
                    TreeNode t = new TreeNode(nums[i]);
                    t.left = l;
                    list.add(t);
                }

            } else {
                for (TreeNode l: left) {
                    for (TreeNode r: right) {
                        TreeNode t = new TreeNode(nums[i]);
                        t.left = l;
                        t.right = r;
                        list.add(t);
                    }
                }
            }
        }

        return list;
    }
}

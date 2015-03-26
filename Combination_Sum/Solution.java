import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] candidates = new int[]{8,7,4,3};
        List<List<Integer>> r = new Solution().combinationSum(candidates, 11);

        for (List<Integer> l: r) {
            for (Integer i: l) {
                System.out.print(i+", ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> r = null;
    int[] candidates = null;
    int target = 0;
    int len = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.len = candidates.length;
        this.target = target;

        Arrays.sort(this.candidates);

        r = new ArrayList<List<Integer>>();
        combination(new ArrayList<Integer>(), 0, 0);
        return r;
    }

    private void combination(List<Integer> nums, int last, int sum) {

        if (sum>target) {
            return;
        }

        if (sum==target) {
            r.add(nums);
            return;
        }

        for (int i=last; i<len; i+=1) {
            List<Integer> n = new ArrayList<Integer>(nums);
            n.add(candidates[i]);
            combination(n, i, sum+candidates[i]);
        }
    }
}

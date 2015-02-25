/**
 * combine(n, k) could be solved by solving combine(n-1, k-1) + combine(n-1, k)
 *
 * k should be not larger than n, so the exit would be (m, 1) or (m, m);
 */
import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> r = s.combine(3, 0);

        for (List<Integer> l: r) {
            for (Integer i: l) {
                System.out.print(i+", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();

        if (k<=0) {
            return r;

        } else if (k==1) {
            for (int i=1; i<=n; i+=1) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(i);
                r.add(l);
            }

        } else if (n==k) {
            List<Integer> l = new ArrayList<Integer>();
            for (int i=1; i<=n; i+=1) {
                l.add(i);
            }
            r.add(l);

        } else {
            r.addAll(combine(n-1, k));

            List<List<Integer>> sub = combine(n-1, k-1);
            for (List<Integer> l: sub) {
                l.add(n);
                r.add(l);
            }
        }

        return r;
    }
}

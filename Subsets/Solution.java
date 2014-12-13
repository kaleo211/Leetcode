import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> r = new Solution().subsets(new int[]{0,1,2});

        for (List<Integer> list: r) {
            for (Integer i: list)
                System.out.print(i+", ");
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] S) {
        int len = S.length;
        Arrays.sort(S);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i=0; i<len; i++) {

            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            List<Integer> f = new ArrayList<Integer>();
            f.add(S[i]);
            tmp.add(f);

            for (List<Integer> list: result) {
                List<Integer> t = new ArrayList<Integer>();
                t.addAll(list);
                t.add(S[i]);
                tmp.add(t);
            }

            result.addAll(tmp);
        }
        result.add(new ArrayList<Integer>());

        return result;
    }
}

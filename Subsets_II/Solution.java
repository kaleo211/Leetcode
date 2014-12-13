import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> r = new Solution().subsetsWithDup(new int[]{5,5,5,5,5});

        for (List<Integer> list: r) {
            for (Integer i: list)
                System.out.print(i+", ");
            System.out.println();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] S) {
        int len = S.length;
        Arrays.sort(S);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if (len==0) {
            return result;
        }

        List<Integer> l = new ArrayList<Integer>(Arrays.asList(S[0]));

        List<List<Integer>> tmp = null;
        List<List<Integer>> cur = null;
        List<List<Integer>> pre = new ArrayList<List<Integer>>();
        pre.add(l);
        result.add(l);

        for (int i=1; i<len; i++) {
            if (S[i]==S[i-1]) {
                cur = pre;
            } else {
                cur = result;
            }

            tmp = new ArrayList<List<Integer>>();
            for (List<Integer> list: cur) {
                List<Integer> t = new ArrayList<Integer>();
                t.addAll(list);
                t.add(S[i]);
                tmp.add(t);
            }

            pre = tmp;
            result.addAll(tmp);
        }

        return result;
    }
}

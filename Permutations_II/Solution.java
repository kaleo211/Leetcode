import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {2, 1, 1};

        List<List<Integer>> r = s.permuteUnique(num);
        for (List<Integer> list: r) {
            for (Integer i: list)
                System.out.print(i+", ");
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = num.length;
        if (len==0) {
            return result;
        }
        int i;
        List<Integer> p = null;

        while (true) {
            p = new ArrayList<Integer>();
            for (i=0; i<len; i++) {
                p.add(num[i]);
            }
            if (result.contains(p)) {
                break;
            }
            result.add(p);
            nextPermutation(num, len);
        }

        return result;
    }

    public void nextPermutation(int[] num, int length) {
        int partition = -1;

        for (int i=length-2; i>=0; i--) {
            if (num[i]<num[i+1]) {
                partition = i;
                break;
            }
        }

        if (partition!=-1) {
            for (int i=length-1; i>partition; i--) {
                if (num[i]>num[partition]) {
                    int tmp = num[partition];
                    num[partition] = num[i];
                    num[i] = tmp;
                    break;
                }
            }
        }

        for (int i=partition+1,j=length-1; i<j; i++, j--) {
            int s = num[i];
            num[i] = num[j];
            num[j] = s;
        }
    }
}

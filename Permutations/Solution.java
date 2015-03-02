import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] n = new int[]{1,2,3};
        List<List<Integer>> r = new Solution().permute(n);
        for (List<Integer> l: r) {
            for (Integer i: l) {
                System.out.print(i+", ");
            }
            System.out.println();
        }
    }


    public List<List<Integer>> permute(int[] num) {
        int len = num.length;
        int total = 1;
        for (int i=1; i<=len; i+=1) {
            total *= i;
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for (int i=0; i<total; i+=1) {
            List<Integer> p = new ArrayList<Integer>();
            for (int j=0; j<len; j+=1) {
                p.add(num[j]);
            }
            list.add(p);
            next(num);
        }

        return list;
    }

    public void next(int[] num) {
        int length = num.length;
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

import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        List<Integer> list = new Solution().getRow(24);
        for (Integer i: list) {
            System.out.println(i);
        }
    }


    public List<Integer> getRow(int n) {

        int[] num = new int[n+1];

        for (int i=0; i<=n; i+=1) {
            num[i]=1;
            for (int j=i-1; j>0; j-=1) {
                num[j] = num[j-1]+num[j];
            }
        }

        List<Integer> list = new ArrayList<Integer>();

        for (int i=0; i<=n; i+=1) {
            list.add(num[i]);
        }
        return list;
    }


    // public List<Integer> getRow(int n) {
    //     List<Integer> list = new ArrayList<Integer>();

    //     double[] factor = new double[n+1];
    //     factor[0] = 1;
    //     for (int i=1; i<=n; i+=1) {
    //         factor[i] = factor[i-1]*i;
    //         System.out.println("i: "+factor[i]);
    //     }

    //     for (int i=0; i<=n; i+=1) {
    //         list.add((int)(factor[n]/(factor[i]*factor[n-i])));
    //     }
    //     return list;
    // }
}

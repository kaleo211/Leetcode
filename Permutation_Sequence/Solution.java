import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    int[] factor = new int[]{1,1,2,6,24,120,720,5040,40320,362880};
    ArrayList<Integer> candicate = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));


    public static void main(String[] args) {
        for (int i=1; i<=120; i++)
            System.out.println(new Solution().getPermutation(5, i));
    }

    public String getPermutation(int n, int k) {
        if (n==0)
            return "";
        int index = k/factor[n-1];

        if (k%factor[n-1]!=0)
            index += 1;

        return candicate.remove(index)+getPermutation(n-1, k-factor[n-1]*(index-1));

    }
}

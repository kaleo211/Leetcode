import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,0,1,2};
        new Solution().sortColors(a);
        for (int i=0; i<a.length; i+=1)
            System.out.println(a[i]+", ");
    }

    public void sortColors(int[] A) {
        int len = A.length;
        int one = 0;
        int two = 0;
        for (int i=0; i<len; i+=1) {
            if (A[i]==1)
                one += 1;
            else if (A[i]==2)
                two += 1;
        }

        Arrays.fill(A, 0, len-two-one, 0);
        Arrays.fill(A, len-two-one, len-two, 1);
        Arrays.fill(A, len-two, len, 2);
    }
}

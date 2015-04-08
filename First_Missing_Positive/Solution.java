public class Solution {

    public static void main(String[] args) {
        int[] A = new int[]{1};
        System.out.println(new Solution().firstMissingPositive(A));
    }


    public int firstMissingPositive(int[] A) {
        int len = A.length;
        if (len==0) {
            return 1;
        }
        int i=0;
        while (i<len) {
            int val = A[i];
            if (val!=i+1 && val>=1 && val<=len && val!=A[val-1]) {
                A[i] = A[val-1];
                A[val-1] = val;
            } else {
                i += 1;
            }
        }

        for (int j=0; j<len; j+=1) {
            if (A[j]!=j+1) {
                return j+1;
            }
        }
        return len+1;
    }
}

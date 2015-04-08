public class Solution {

    public static void main(String[] args) {
        int[] A = new int[]{1,1,1,2,2,3};
        System.out.println(new Solution().removeDuplicates(A));
        for (int i=0; i<A.length; i+=1) {
            System.out.print(A[i]+", ");
        }
        System.out.println();
    }

    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len<2) {
            return len;
        }

        int no = 1;
        boolean dup = false;
        for (int i=1; i<len; i+=1) {
            if (A[i]==A[i-1]) {
                if (!dup) {
                    A[no] = A[i];
                    no += 1;
                    dup = true;
                }
            } else {
                dup = false;
                A[no] = A[i];
                no += 1;
            }
        }
        return no;
    }
}

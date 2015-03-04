public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{4,3,3,9,3,0,9,2,8,3};
        System.out.println(s.trap(a));
    }

    public int trap(int[] A) {

        int len = A.length;
        if (len<1) {
            return 0;
        }

        int sum = 0, max = 0, total = 0;
        int index_of_max = 0;

        boolean[] forward = new boolean[len];
        boolean[] backward = new boolean[len];

        forward[0] = true;
        max = A[0];
        int last_forward = 0;
        for (int i=1; i<len; i+=1) {
            if (A[i]>=max) {
                max = A[i];
                forward[i] = true;
                last_forward = i;
            } else {
                forward[i] = false;
            }
        }

        backward[len-1] = true;
        max = A[len-1];
        int last_backward = len-1;
        for (int i=len-2; i>=0; i-=1) {
            if (A[i]>=max) {
                max = A[i];
                backward[i] = true;
                last_backward = i;
            } else {
                backward[i] = false;
            }
        }

        total = 0;
        int last = A[0];
        sum = 0;
        for (int i=1; i<=last_forward; i+=1) {
            if (forward[i]) {
                total += sum;
                // System.out.println("i: "+i+" sum: "+sum);
                sum = 0;
                last = A[i];

            } else {
                sum += (last - A[i]);
            }
        }

        last = A[len-1];
        sum = 0;
        for (int i=len-2; i>=last_backward; i-=1) {
            if (backward[i]) {
                // System.out.println("ii: "+i+" sum: "+sum);
                total += sum;
                sum = 0;
                last = A[i];

            } else {
                sum += (last - A[i]);
            }
        }

        int sub = 0;
        if (last_forward>last_backward) {
            sum = 0;
            for (int i=last_backward+1; i<=last_forward; i+=1) {
                if (forward[i]) {
                    sub += sum;
                    System.out.println("i: "+i+" sum: "+sum);
                    sum = 0;
                    last = A[i];

                } else {
                    sum += (last - A[i]);
                }
            }
        }

        return total-sub;
    }
}

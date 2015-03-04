public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{0,1};
        System.out.println(new Solution().canJump(a));
    }

    public boolean canJump(int[] A) {

        int len = A.length;
        if (len<1) {
            return false;
        }

        int end = Integer.MIN_VALUE;

        for (int i=0; i<len; i+=1) {
            if (A[i]==0 && end<=i && i!=len-1) {
                return false;
            } else {
                end = max(end, i+A[i]);
            }
        }

        return true;
    }

    private int max(int a, int b) {
        return a>b?a:b;
    }
}

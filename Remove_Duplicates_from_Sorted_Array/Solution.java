public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,2,2,3,3,3,4,5,6,6,6,6,6,6,7,88888};
        System.out.println("len: "+new Solution().removeDuplicates(a));
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i]+",");
        }
    }

    public int removeDuplicates(int[] A) {
        int next = 1;
        int len = A.length;
        if (len==0)
            return 0;

        for (int i=1; i<len; i++) {
            if (A[i]!=A[i-1]) {
                A[next] = A[i];
                next += 1;
            }
        }
        return next;
    }
}

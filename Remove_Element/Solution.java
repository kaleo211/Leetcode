public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{4};

        int len = new Solution().removeElement(a, 4);
        for (int i=0; i<len; i++)
            System.out.print(a[i]+", ");
        System.out.println();
    }

    public int removeElement(int[] A, int elem) {

        int len = A.length;
        if (len==0)
            return 0;
        int last = len-1;
        while (last>=0 && A[last]==elem) {
            last -= 1;
        }

        for (int i=0; i<last; i++) {
            if (A[i]==elem) {
                A[i] = A[last];
                last -= 1;
                while (A[last]==elem) {
                    last -= 1;
                }
            }
        }

        return last+1;
    }
}

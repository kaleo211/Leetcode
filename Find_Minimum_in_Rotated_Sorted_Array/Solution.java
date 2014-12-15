public class Solution {

    int[] A;
    int len;

    public static void main(String[] args) {
        int[] a = new int[]{5, 6, 1, 2};
        System.out.println(new Solution().findMin(a));
    }

    public int findMin(int[] num) {
        this.A = num;
        this.len = A.length;
        if (len==0)
            return -1;

        return xsearch(0, len-1);
    }


    private int xsearch(int low, int high) {
        System.out.println("X low: "+low+" high: "+high);
        if (A[low]<=A[high])
            return A[low];

        int mid = (low+high)/2;
        if (mid>0 && A[mid]<A[mid-1] || mid==0 && A[0]<=A[len-1])
            return A[mid];

        if (mid!=low && A[low]>A[mid-1])
            return xsearch(low, mid-1);
        return xsearch(mid+1, high);
    }
}

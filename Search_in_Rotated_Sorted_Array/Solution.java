public class Solution {

    int[] A;
    int target;

    public static void main(String[] args) {
        int[] a = new int[]{5,1,3};
        System.out.println(new Solution().search(a, 3));
    }

    public int search(int[] A, int target) {
        this.A = A;
        this.target = target;
        int len = A.length;
        if (len==0)
            return -1;

        return xsearch(0, len-1);
    }

    private int bsearch(int low, int high) {
        System.out.println("B low: "+low+" high: "+high);
        if (high<low)
            return -1;
        int mid = (low+high)/2;
        if (target==A[mid])
            return mid;
        if (target<A[mid])
            return bsearch(low, mid-1);
        return bsearch(mid+1, high);
    }

    private int xsearch(int low, int high) {
        System.out.println("X low: "+low+" high: "+high);

        if (high<low || (low==high && A[low]!=target))
            return -1;

        int mid = (low+high)/2;
        if (target==A[mid])
            return mid;

        if (target>=A[low] && target<A[mid])
            return bsearch(low,mid);

        if (mid>=0 && A[low]>A[mid] &&
                (target<=A[low] && target<=A[mid] ||
                 target>=A[low] && target>=A[mid]))
            return xsearch(low, mid);

        if (target>=A[mid+1] && target<=A[high])
            return bsearch(mid+1, high);

        return xsearch(mid+1, high);
    }
}

/**
 * bsearch: search in sorted array
 * xsearch: search in rotated array
 *
 * if duplicate are allowed, the only different case is below.
 * sequence: 1, 3, 5, 1, 1
 * when last equals first, simply remove first one in xsearch
 */

public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,1};
        System.out.println(new Solution().search(a, 1));
    }

    public boolean search(int[] A, int target) {
        int len = A.length;
        if (len==0)
            return false;

        if (xsearch(A, target, 0, len-1)>=0)
            return true;
        return false;
    }

    private int bsearch(int[] A, int target, int low, int high) {
        System.out.println("B low: "+low+" high: "+high);
        if (high<low)
            return -1;
        int mid = (low+high)/2;
        if (target==A[mid])
            return mid;
        if (target<A[mid])
            return bsearch(A, target, low, mid-1);
        return bsearch(A, target, mid+1, high);
    }

    private int xsearch(int[] A, int target, int low, int high) {
        System.out.println("X low: "+low+" high: "+high);

        if (high<low || (low==high && A[low]!=target))
            return -1;

        while (A[low]==A[high] && low!=high) {
            low += 1;
        }
        if (low==high && A[low]!=target) {
            return -1;
        }

        int mid = (low+high)/2;
        if (target==A[mid])
            return mid;

        if (target>=A[low] && target<A[mid])
            return bsearch(A, target, low,mid);

        if (mid>=0 && A[low]>A[mid] &&
                (target<=A[low] && target<=A[mid] ||
                 target>=A[low] && target>=A[mid]))
            return xsearch(A, target, low, mid);

        if (target>=A[mid+1] && target<=A[high])
            return bsearch(A, target, mid+1, high);

        return xsearch(A, target, mid+1, high);
    }
}

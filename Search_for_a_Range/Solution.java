public class Solution {

    private int[] A;
    private int target;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[] {};
        int[] r = s.searchRange(A, 7);
        System.out.println("l: "+ r[0] + " r: "+r[1]);
    }

    public int[] searchRange(int[] A, int target) {
        this.A = A;
        this.target = target;
        int len = A.length;

        return new int[] {left(0, len-1), right(0, len-1)};
    }

    private int left(int low, int high) {
        if (low>high)
            return -1;

        int mid = (low+high)/2;
        if (A[mid]==target && (mid==0 || A[mid-1]!=target)) {
            return mid;
        }

        if (A[mid]>=target)
            return left(low, mid-1);
        return left(mid+1, high);
    }

    private int right(int low, int high) {
        if (low>high)
            return -1;

        int mid = (low+high)/2;
        if (A[mid]==target && (mid==A.length-1 || A[mid+1]!=target)) {
            return mid;
        }

        if (A[mid]>target)
            return right(low, mid-1);
        return right(mid+1, high);
    }
}

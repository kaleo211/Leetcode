public class Solution {

    private int[] A;
    private int target;

    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[]{1,3,5,6}, 5));
    }

    public int searchInsert(int[] A, int target) {
        int len = A.length;
        if (len==0 || target<A[0])
            return 0;
        if (target>A[len-1])
            return len;
        this.A = A;
        this.target = target;
        return bsearch(0, len-1);
    }

    private int bsearch(int low, int high) {
        if (A[low]==target || (low-1>=0 && target>A[low-1] && target<A[low])) {
            return low;
        }
        if (A[high]==target || (high-1>=0 && target>A[high-1] && target<A[high])) {
            return high;
        }
        int mid = (low+high)/2;
        if (target <= A[mid])
            return bsearch(low, mid);
        else
            return bsearch(mid, high);
    }
}

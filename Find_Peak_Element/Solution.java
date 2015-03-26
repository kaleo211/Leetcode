public class Solution {


    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,1};
        System.out.println(new Solution().findPeakElement(n));
    }

    int peak = 0;
    int[] num = null;

    public int findPeakElement(int[] num) {

        int len = num.length;
        if (len==1 || num[0]>num[1]) {
            return 0;
        }
        if (num[len-1]>num[len-2]) {
            return len-1;
        }

        this.num = num;
        find(1, num.length-2);
        return peak;
    }

    private void find(int low, int high) {
        if (low>high) {
            return;
        }

        if (num[low]>num[low+1] && num[low]>num[low-1]) {
            peak = low;
            return;
        }
        if (num[high]>num[high+1] && num[high]>num[high-1]) {
            peak = high;
            return;
        }

        int mid = (low+high)/2;
        find(low+1, mid);
        find(mid+1, high-1);
    }
}

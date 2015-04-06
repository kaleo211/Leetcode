public class Solution {

    public static void main(String[] args) {
        int[] num = new int[]{7, 3, 4, 1, 8, 6, 1};
        System.out.println(new Solution().rob(num));
    }

    public int rob(int[] num) {
        int len = num.length;

        if (len==0) {
            return 0;
        }
        if (len==1) {
            return num[0];
        }

        int[] sum = new int[len];
        sum[0] = num[0];
        sum[1] = num[1];
        int max = num[0];
        for (int i=2; i<len; i+=1) {
            sum[i] = num[i]+max;
            max = sum[i-1]>max?sum[i-1]:max;
        }

        return sum[len-2]>sum[len-1]?sum[len-2]:sum[len-1];
    }
}

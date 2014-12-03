public class Solution {

    public static void main(String[] args) {
        int[] s = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("max: "+new Solution().maxSubArray(s));
    }

    public int maxSubArray(int[] A) {
        int len = A.length;
        if (len==0) return 0;

        int sum = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for (int i=0; i<len; i++) {
            if (A[i]<0) {
                if (sum<0) {
                    sum = A[i];
                } else {
                    sum += A[i];
                }
            } else {
               if (sum>0) {
                    sum += A[i];
               } else {
                    sum = A[i];
               }
            }
            max = max<sum ? sum : max;
            System.out.println("i: "+i+ " A[i]: "+A[i]+" sum: "+sum +" max: " +max);
        }
        return max;
    }


    public int maxSubArray_TIME_LIMIT_EXCEEDED(int[] A) {
        int len = A.length;

        if (len==0)
            return 0;

        int[][] sum = new int[len][len];
        for (int i=0; i<len; i++) {
            sum[i][i] = A[i];
        }

        int max = A[0];
        for (int step=1; step<len; step++) {
            for (int i=0; i<len-step; i++) {
                int end = i+step;
                int s = sum[i][end-1] + sum[end][end];
                max = max< s ? s : max;
                sum[i][i+step] = s;
            }
        }
        return max;
    }
}

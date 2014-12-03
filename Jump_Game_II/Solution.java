public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{9,8,7,6,5,4,3,2,1,0};
        System.out.println(new Solution().jump(a));
    }

    public int jump(int[] A) {
        int len = A.length;
        if (len<2)
            return 0;

        int step=0, start=0, end=0, i, new_end;

        while (step<len) {
            step += 1;
            for (i=start; i<=end; i++) {
                if (i+A[i]>=len-1)
                    return step;
                if (i+A[i]>new_end)
                    new_end = i+A[i]
            }
        }
    }
}

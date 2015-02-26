public class Solution {

    public static void main(String[] args) {
        int[]  n = new int[] {1,2,3,4,5,6,7};
        new Solution().rotate(n, 6+77);
        for(int i=0; i<n.length; i+=1) {
            System.out.println(n[i]+", ");
        }
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len<1) {
            return;
        }
        k = k%len;

        if (k<len/2) {
            while (k!=0) {
                k -= 1;
                int tmp = nums[len-1];
                for (int i=len-1; i>0; i-=1) {
                    nums[i] = nums[i-1];
                }
                nums[0] = tmp;
            }
        } else {
            k = len - k;
            while (k!=0) {
                k -= 1;
                int tmp = nums[0];
                for (int i=0; i<len-1; i+=1) {
                    nums[i] = nums[i+1];
                }
                nums[len-1] = tmp;
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(Integer.MAX_VALUE));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;

        for (int i=0; i<32; i+=1) {
            num += n&1;
            n = n>>>1;
        }
        return num;
    }
}

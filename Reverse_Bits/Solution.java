public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(1));
    }
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long num = 0;
        System.out.println(Integer.MAX_VALUE);
        for (int i=0; i<32; i+=1) {
            num = num<<1;
            num += n&1;
            n = n>>>1;
        }
        return (int)num;
    }

}

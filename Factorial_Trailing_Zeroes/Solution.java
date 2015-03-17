public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(2147483647));
    }

    public int trailingZeroes(int n) {
        int num = 0;
        long f = 5;
        while (f<=n) {
            num += n/f;
            f *= 5;
        }
        return num;
    }
}

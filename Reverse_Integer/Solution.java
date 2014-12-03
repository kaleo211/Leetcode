public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(1534236469));
    }

    public int reverse(int x) {
        boolean negative = false;
        if (x<0) {
            negative = true;
            x = x*(-1);
        }
        long number = 0;
        char[] n = new StringBuilder(String.valueOf(x)).reverse().toString().toCharArray();
        int length = n.length;

        for (int i=0; i<length; i++) {
            if (number<=Integer.MAX_VALUE)
                number = number*10 + n[i]-48;
            else
                return 0;
        }
        if (number>Integer.MAX_VALUE)
            return 0;
        else {
            if (negative)
                number = number*(-1);
            return (int)number;
        }
    }
}

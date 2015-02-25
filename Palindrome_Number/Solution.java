/**
 * compare the last digit and the first digit
 */


public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(12321));
    }

    public boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }

        int factor=1;
        int xx = x/10;
        while (xx!=0) {
            factor *= 10;
            xx /= 10;
        }

        while (x!=0) {
            int last = x%10;
            int first = x/factor;

            if (last!=first) {
                return false;
            }
            x = (x-first*factor)/10;
            factor /= 100;
        }
        return true;
    }
}

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(" "));
    }

    public boolean isPalindrome(String s) {
        char[] ss = s.toLowerCase().toCharArray();
        int len = ss.length;

        int f = 0, e = len-1;
        while (true) {
            if (f>e) {
                break;
            }
            while ( f<len && ! ((ss[f]>='0' && ss[f]<='9') || (ss[f]>='a' && ss[f]<='z')) ) {
                f += 1;
            }
            while ( e>=0 && ! ((ss[e]>='0' && ss[e]<='9') || (ss[e]>='a' && ss[e]<='z')) ) {
                e -= 1;
            }
            if (f>=len || ss[f]!=ss[e]) {
                return false;
            }
            f += 1;
            e -= 1;
        }

        return true;
    }
}

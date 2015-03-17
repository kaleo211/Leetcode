public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("AAA"));
    }

    public int titleToNumber(String s) {
        char[] ss = s.toUpperCase().toCharArray();
        int len = ss.length;

        int value = 0;
        for (int i=0; i<len; i+=1) {
            value = value*26 + (ss[i]-'A'+1);
        }

        return value;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.atoi("-1"));
    }

    public int atoi(String str) {
        str = str.trim();
        int len = str.length();
        if (len==0)
            return 0;

        long value = 0;
        boolean negative = false;
        int i = 0;
        if (str.charAt(0)=='-') {
            i = 1;
            negative = true;
        } else if (str.charAt(0)=='+'){
            i = 1;
        }
        if (str.charAt(i)>'9' || str.charAt(i)<'0')
            return 0;

        for (; i<len; i++) {
            char c = str.charAt(i);
            if (c<='9' && c>='0') {
                value = value*10 + str.charAt(i)-48;
                if (negative && value<(-1)*Integer.MIN_VALUE || value>Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }
        if (negative) {
            value = (-1)*value;
            if (value<Integer.MIN_VALUE)
                value = Integer.MIN_VALUE;
        } else {
            if (value>Integer.MAX_VALUE)
                value = Integer.MAX_VALUE;
        }

        return (int)value;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(2));
    }

    public String countAndSay(int n) {
        String say = "1";
        int length;
        int count;
        for (int i=1; i<n; i++) {
            char[] s = say.toCharArray();
            length = s.length;
            StringBuffer r = new StringBuffer();
            count = 1;
            char cur = s[0];
            for (int j=1; j<length; j++) {
                if (s[j]!=cur) {
                    r.append(String.valueOf(count)+cur);
                    cur = s[j];
                    count = 1;
                } else {
                    count += 1;
                }
            }
            r.append(String.valueOf(count)+cur);
            say = r.toString();
        }
        return say;
    }
}

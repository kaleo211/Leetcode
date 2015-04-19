public class Solution {

    public static void main(String[] args) {
        String[] a = new String[]{"abc", "abcdf", "ab"};
        System.out.println(new Solution().longestCommonPrefix(a));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length<1 || strs[0].length()<1) return "";

        char[] basic = strs[0].toCharArray();
        int s = basic.length;
        boolean broked = false;
        for (int i=0; i<basic.length&&!broked; i+=1) {
            for (int j=1; j<strs.length&&!broked; j+=1) {
                if (i>=strs[j].length() || basic[i]!=strs[j].charAt(i)) {
                    s = i;
                    broked = true;
                }
            }
        }

        if (s==0) return "";
        return strs[0].substring(0, s);
    }
}

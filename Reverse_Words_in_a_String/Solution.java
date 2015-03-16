public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("1 "));
    }

    public String reverseWords(String s) {

        s = s.replaceAll(" +", " ").trim();

        if (s.equals(" ")) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        int len = ss.length;
        for (int i=len-1; i>0; i-=1) {
            sb.append(ss[i]);
            sb.append(" ");
        }
        sb.append(ss[0]);
        return sb.toString();
    }
}

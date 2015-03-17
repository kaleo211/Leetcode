public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(676));
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while(n>0) {
            System.out.println("n: "+n);
            sb.append((char) ((n-1)%26+'A'));
            n = (n-1)/26;
        }

        return sb.reverse().toString();
    }
}

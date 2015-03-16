/**
 * CHEET
 *
 * JAVA, GOOD JOB!
 */



public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isNumber("+1"));
    }

    public boolean isNumber(String s) {
        String ss = s.toLowerCase();
        if (ss.contains("f") || ss.contains("l") || ss.contains("d")) {
            return false;
        }

        try {
            double n = Double.valueOf(ss);
            System.out.println(Double.toString(n));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXC"));
    }

    public int romanToInt(String s) {
        s = s.toLowerCase();

        int num = 0;

        while (s.length()>0) {
            if (s.startsWith("iv")) {
                num += 4;
                s = s.substring(2, s.length());

            } else if (s.startsWith("ix")) {
                num += 9;
                s = s.substring(2, s.length());

            } else if (s.startsWith("i")) {
                num += 1;
                s = s.substring(1, s.length());

            } else if (s.startsWith("v")) {
                num += 5;
                s = s.substring(1, s.length());

            } else if (s.startsWith("xl")) {
                num += 40;
                s = s.substring(2, s.length());

            } else if (s.startsWith("xc")) {
                num += 90;
                s = s.substring(2, s.length());

            } else if (s.startsWith("x")) {
                num += 10;
                s = s.substring(1, s.length());

            } else if (s.startsWith("l")) {
                num += 50;
                s = s.substring(1, s.length());

            } else if (s.startsWith("cd")) {
                num += 400;
                s = s.substring(2, s.length());

            } else if (s.startsWith("cm")) {
                num += 900;
                s = s.substring(2, s.length());

            } else if (s.startsWith("c")) {
                num += 100;
                s = s.substring(1, s.length());

            } else if (s.startsWith("d")) {
                num += 500;
                s = s.substring(1, s.length());

            } else if (s.startsWith("m")) {
                num += 1000;
                s = s.substring(1, s.length());
            }
        }

        return num;
    }
}

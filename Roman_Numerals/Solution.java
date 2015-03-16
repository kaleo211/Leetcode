public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(1));
    }

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        int t = num/1000;
        num = num%1000;

        while(t>0) {
            sb.append("M");
            t -= 1;
        }

        int h = num/100;
        num = num%100;
        sb.append(build(h, "C", "D", "M"));

        int d = num/10;
        num = num%10;
        sb.append(build(d, "X", "L", "C"));

        sb.append(build(num, "I", "V", "X"));

        return sb.toString();
    }

    private String build(int bit, String i, String v, String x) {
        StringBuilder sb = new StringBuilder();

        if (bit<4) {
            while (bit>0) {
                sb.append(i);
                bit -= 1;
            }
        } else if (bit==4) {
            sb.append(i+v);
        } else if (bit==9) {
            sb.append(i+x);
        } else {
            sb.append(v);
            bit -= 5;
            while (bit>0) {
                sb.append(i);
                bit -= 1;
            }
        }

        return sb.toString();
    }
}

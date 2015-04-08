public class Solution {

    public static void main(String[] args) {
        // System.out.println(new Solution().multiply("123", "456"));
        System.out.println(new Solution().add("6888".toCharArray(), "49200".toCharArray()));
    }

    public String multiply(String num1, String num2) {
        char[] n1 = num1.replaceAll("\\+", "").toCharArray();
        char[] n2 = num2.replaceAll("\\+", "").toCharArray();
        int l1 = n1.length, l2 = n2.length;
        String n = "0";

        int k = 0;
        for (int i=0; i<l2; i+=1) {
            k = l2-i-1;
            String r = time(n1, n2[k]);
            int j = 0;
            while (j<i) {
                r = r+"0";
                j+=1;
            }
            if (r.matches("0+")) {
                r = "0";
            }
            n = add(n.toCharArray(), r.toCharArray());
            if (n.matches("0+")) {
                n = "0";
            }
            // System.out.println("n: "+n+" r: "+r);
        }

        return n;
    }

    private String time(char[] num1, char num2) {
        if (num2=='0') {
            return "0";
        }
        if (num2=='1') {
            return new String(num1);
        }

        int len = num1.length;

        int k = 0, c = 0;
        StringBuilder sb = new StringBuilder();

        for (int i=len-1; i>=0; i-=1) {
            c = (num1[i]-'0')*(num2-'0')+k;
            k = c/10;
            c = c%10;
            sb.append((char)(c+'0'));
        }
        if (k>0) {
            sb.append((char)(k+'0'));
        }

        return sb.reverse().toString();
    }

    private String add(char[] num1, char[] num2) {
        char[] large = null, small = null;
        if (num1.length>num2.length) {
            large = num1;
            small = num2;
        } else {
            large = num2;
            small = num1;
        }
        int l = large.length, s = small.length;
        StringBuilder sb = new StringBuilder();
        int one = 0, bit = 0;
        for (int i=s-1; i>=0; i-=1) {
            bit = large[i+l-s]-'0'+small[i]-'0'+one;
            one = bit/10;
            bit = bit%10;
            sb.append((char)(bit+'0'));
        }

        for (int i=l-s-1; i>=0; i-=1) {
            if (one==1) {
                if (large[i]=='9') {
                    sb.append('0');
                    one = 1;
                } else {
                    sb.append((char)(large[i]+1));
                    one = 0;
                }
            } else {
                sb.append(large[i]);
                one = 0;
            }
        }
        if (one==1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}


public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1", "0000"));
    }

    public String addBinary(String a, String b) {
        char[] aa, bb;
        if (a.length()>b.length()) {
            aa = a.toCharArray();
            bb = b.toCharArray();
        } else {
            aa = b.toCharArray();
            bb = a.toCharArray();
        }
        int la = aa.length, lb = bb.length;

        int f = 0, i=1;
        for (; i<=lb; i+=1) {
            int k = (aa[la-i]-'0') + (bb[lb-i]-'0') + f;
            if (k>1) {
                aa[la-i] = (char)('0'+k%2);
                f = 1;
            } else {
                aa[la-i] = (char)('0'+k);
                f = 0;
            }
        }

        while (f>0 && i<=la) {
            if (f+aa[la-i]>'1') {
                aa[la-i] = '0';
                f = 1;
            } else {
                aa[la-i] += f;
                f = 0;
            }
            i += 1;
        }

        StringBuilder sb = new StringBuilder();
        if (f==1) {
            sb.append('1');
        }
        for (int j=0; j<la; j+=1) {
            sb.append(aa[j]);
        }
        return sb.toString();
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aab", "c*a*b"));
    }

    public boolean isMatch(String s, String p) {
        char[]  a1=s.toCharArray(), a2=p.toCharArray();
        int     l1=a1.length, l2=a2.length;

        int i1=0, i2=0, pre_i1=0, pre_i2=0;
        boolean star = false;
        while (i1<l1) {
            if (i2<l2 && (a1[i1]==a2[i2] || a2[i2]=='?')) {
                i1 += 1;
                i2 += 1;

            } else {
                if (i2<l2 && a2[i2]=='*') {
                    star = true;
                    while (i2<l2 && a2[i2]=='*') i2 += 1;
                    if (i2==l2) return true;
                    pre_i1 = i1;
                    pre_i2 = i2;

                } else if (star) {
                    pre_i1 += 1;
                    i1 = pre_i1;
                    i2 = pre_i2;

                } else {
                    return false;
                }
            }
        }

        while (i2<l2 && a2[i2]=='*') {
            i2 += 1;
        }
        if (i2==l2)
            return true;
        return false;
    }

    // Time Limit Exceeded
    // DP cant not pass large data
    public boolean isMatchFAIL(String s, String p) {
        char[]  a1=s.toCharArray(), a2=p.toCharArray();
        int     l1=a1.length, l2=a2.length;

        // m[i][j] stands for the substring(0, i) of s whether match substring(0, j) of p
        boolean[][] m = new boolean[l1+1][l2+1];

        int i1, i2;
        m[0][0] = true;
        for (i1=1; i1<=l1; i1+=1) {
            for (i2=1; i2<=l2; i2+=1) {
                if (m[i1-1][i2-1] || (a2[i2-1]=='*' && m[i1][i2-1])) {

                    if (a2[i2-1]=='*' || a2[i2-1]=='?' || a2[i2-1]==a1[i1-1]) {
                        m[i1][i2] = true;
                    }

                    // if it's a *, it can match all string after a1[i1-1]
                    if (a2[i2-1]=='*') {
                        for (int i=i1-1; i<=l1; i+=1)
                            m[i][i2-1] = true;
                    }
                }
                System.out.println("i1: "+i1+" i2: "+i2+" m: "+m[i1][i2] +" mp: "+m[i1-1][i2-1]);
            }
        }

        return m[l1][l2];
    }
}

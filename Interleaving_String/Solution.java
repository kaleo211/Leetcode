public class Solution {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ac";

        System.out.println(new Solution().isInterleave(s1,s2, s3));
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        char[]  a1=s1.toCharArray(), a2=s2.toCharArray(), a3=s3.toCharArray();
        int     l1=a1.length, l2=a2.length, l3=a3.length;
        if (l1+l2!=l3) {
            return false;
        }

        boolean[][] m = new boolean[l1+1][l2+1];
        m[0][0] = true;
        for (int i=1; i<=l1; i++) {
            if (a3[i-1]!=a1[i-1])
                break;
            m[i][0] = true;
        }
        for (int i=1; i<=l2; i++) {
            if (a3[i-1]!=a2[i-1])
                break;
            m[0][i] = true;
        }

        int i1=0, i2=0, i3=0;
        for (i1=1; i1<=l1; i1+=1) {
            for (i2=1; i2<=l2; i2+=1) {
                if (m[i1-1][i2]==true && a3[i1+i2-1]==a1[i1-1]) {
                    m[i1][i2] = true;
                }
                if (m[i1][i2-1]==true && a3[i1+i2-1]==a2[i2-1]) {
                    m[i1][i2] = true;
                }
            }
        }

        return m[l1][l2];
    }

    // // Time Limit Exceeded
    // public boolean isInterleave(String s1, String s2, String s3) {
    //     a1=s1.toCharArray();
    //     a2=s2.toCharArray();
    //     a3=s3.toCharArray();
    //     l1=a1.length;
    //     l2=a2.length;
    //     l3=a3.length;

    //     return inter(0, 0, 0);
    // }

    // private boolean inter(int i1, int i2, int i3) {

    //     for (; i3<l3; i3+=1) {

    //         if (i1<l1 && i2<l2 && a1[i1]==a2[i2]) {
    //             return inter(i1+1, i2, i3+1) || inter(i1, i2+1, i3+1);  // redundancy calculation, need dp
    //         }
    //         if (i1<l1 && a1[i1]==a3[i3]) {
    //             i1 += 1;
    //         } else if (i2<l2 && a2[i2]==a3[i3]) {
    //             i2 += 1;
    //         } else {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}

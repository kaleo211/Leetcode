import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minCut("a"));
    }

    public int minCut(String s) {
        char[] ss = s.toCharArray();
        int len = ss.length;
        if (len<1) {
            return 0;
        }

        boolean[][] palindrome = new boolean[len+1][len+1];

        for (int i=1; i<len+1; i+=1) {
            palindrome[i][i] = true;
        }

        for (int l=1; l<len; l+=1) {
            for (int i=1; i+l<=len; i+=1) {
                // System.out.println("i: "+ss[i-1]+" j: "+ss[l+i-1]+" l: "+l);
                if (ss[i-1]==ss[i+l-1]) {
                    if ( l==1 || (l>=2 && palindrome[i+1][i+l-1])) {
                        palindrome[i][i+l] = true;
                    }
                }
                // System.out.println("i: "+i+" j: "+(i+l)+" "+palindrome[i][i+l]);
            }
        }

        int[] cut = new int[len+1];
        Arrays.fill(cut, Integer.MAX_VALUE);
        cut[0] = -1;
        for (int i=1; i<len+1; i+=1) {
            for (int j=0; j<i; j+=1) {
                // System.out.println(" j: "+j+" i:"+i+" "+palindrome[i][j]);
                if (palindrome[j+1][i] && cut[j]+1<cut[i]) {
                    cut[i] = cut[j]+1;
                }
            }
        }

        return cut[len];
    }
}

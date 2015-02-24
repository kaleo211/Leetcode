/**
 * let p[i][j] be the value that if substring from i to j is a palidrome.
 *  so p[i][i]          = true
 *       p[i][i+1]      = s[i]==s[i+1]
 *       p[i][j]          = s[i]==s[j] and p[i+1][j-1]
 */

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome(""));
    }

    public String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int len = ss.length;
        if (len==0) {
            return "";
        }

        boolean[][] p = new boolean[len][len];
        for (int i=0; i<len; i+=1) {
            p[i][i] = true;
        }

        for (int l=1; l<len; l+=1) {
            for (int i=0; i+l<len; i+=1) {
                int j = i+l;
                if (ss[i]==ss[j] && (l==1 || p[i+1][j-1])) {
                    // System.out.println("ii: "+i+" jj: "+j+" ss[i]:"+ss[i]+" ss[j]: "+ss[j]);
                    p[i][j] = true;
                }
            }
        }

        int start=0, end=0;
        boolean find = false;
        for (int sum=len-1; sum>0 && !find; sum-=1) {
            for (int i=0; sum+i<len && !find; i+=1) {
                if (p[i][sum+i]) {
                    start = i;
                    end = sum+i;
                    // System.out.println("i: "+i+" j: "+(sum+i));
                    find = true;
                }
            }
        }

        return s.substring(start, end+1);
    }
}

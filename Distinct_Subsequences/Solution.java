/**
 * num[i][j] stands for the number of substring(0, i) of t
 *     that occurs in substring(0, j) of s
 *
 * num[i][j] = num[i][j-1] if t[i]!=s[j]
 *               = num[i-1][j-1] + num[i][j-1] if t[i]==s[j]
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numDistinct("ccc", "c"));
    }

    public int numDistinct(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        int s_len = s.length, t_len = t.length;
        int[][] num = new int[t_len][s_len];

        if (s_len==0 || t_len==0 || t_len>s_len) {
            return 0;
        }

        for (int i=0; i<t_len; i+=1) {
            num[i][i] = 0;
        }
        for (int i=0; i<t_len; i+=1) {
            if (t[i]==s[i]) {
                num[i][i] = 1;
            } else {
                break;
            }
        }

        for (int i=0; i<t_len; i+=1) {
            for (int j=i+1; j<s_len; j+=1) {
                num[i][j] = num[i][j-1];
                if (t[i]==s[j]) {
                    if (i>0) {
                        num[i][j] += num[i-1][j-1];
                    } else {
                        num[i][j] += 1;
                    }
                }
                // System.out.println("i: "+i+" j: "+j+" num: "+num[i][j]);
            }
        }

        return num[t_len-1][s_len-1];
    }
}

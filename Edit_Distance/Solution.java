/**
 * f[i,j] = min { f[i-1,j]+1,                                    // add
 *                    f[i,j-1]+1,                                    // delete
 *                    f[i-1,j-1] + (s[i]==t[j]?0:1) }         // replace
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("a", "abcdd"));
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        if (len1==0) {
            return len2;
        }
        if (len2==0) {
            return len1;
        }

        int[][] distance = new int[len1][len2];
        char[] s1 = word1.toCharArray(), s2 = word2.toCharArray();

        if (s1[0]==s2[0]) {
            distance[0][0] = 0;
        } else {
            distance[0][0] = 1;
        }

        for (int i=1; i<len1; i+=1) {
            if (s1[i]==s2[0]) {
                distance[i][0] = i;
            } else {
                distance[i][0] = distance[i-1][0]+1;
            }
        }

        for (int i=1; i<len2; i+=1) {
            if (s2[i]==s1[0]) {
                distance[0][i] = i;
            } else {
                distance[0][i] = distance[0][i-1]+1;
            }
        }

        int add=0, delete=0, replace=0;
        for (int i=1; i<len2; i+=1) {
            for (int j=1; j<len1; j+=1) {
                add = distance[j-1][i]+1;
                delete = distance[j][i-1]+1;
                replace = distance[j-1][i-1] + (s1[j]==s2[i]?0:1);

                distance[j][i] = min(add, min(delete, replace));
            }
        }

        return distance[len1-1][len2-1];
    }

    private int min(int a, int b) {
        return a>b?b:a;
    }
}

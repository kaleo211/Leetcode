/**
 * ways[n] indicate the ways of decoding string length of n
 *
 * equation: ways[n] = ways[n-1] + ( ways[n-2] if string[n-1, n] is valid )
 *
 * should consider 10, 20
 */

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("1310"));
    }

    public int numDecodings(String s) {
        char[] ss = s.toCharArray();
        int len = ss.length;

        if (len<1 || ss[0]=='0') {
            return 0;
        }

        int[] ways = new int[len+1];
        Arrays.fill(ways, 0);
        ways[0] = 1;
        ways[1] = 1;

        for (int i=2; i<=len; i+=1) {
            ways[i] += ways[i-1];


            if (ss[i-1]=='0') {
                // unable to decode
                if (ss[i-2]!='2' && ss[i-2]!='1') {
                    return 0;
                } else {
                    ways[i] = ways[i-2];
                }

            } else if (( ss[i-2]=='1' || (ss[i-2]=='2' && ss[i-1]<'7') )) {
                ways[i] = ways[i-1] + ways[i-2];
            } else {
                ways[i] = ways[i-1];
            }
            // System.out.println(i+": "+ways[i]+", ");
        }

        return ways[len];
    }
}

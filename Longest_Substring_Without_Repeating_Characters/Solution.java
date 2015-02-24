/**
 * let an array last[256] store the last location of every character
 * so everytime find an existed character, update the start position of the substring.
 */

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {

        char[] ss = s.toCharArray();
        int len = ss.length;

        int[] last = new int[256];
        Arrays.fill(last, -1);
        int max = 0, start = 0, cur, index;

        for (int i=0; i<len; i+=1) {
            index = ss[i];
            if ( last[index] != -1 && start<=last[index]) {
                start = last[index]+1;
            } else {
                cur = i - start + 1;
                if (cur > max) {
                    max = cur;
                }
            }
            last[index] = i;
        }

        return max;
    }
}

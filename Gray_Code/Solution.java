/**
 *
 *2-bit list:                                 00, 01, 11, 10
 *Reflected:                                                              10, 11, 01, 00
 *Prefix old entries with 0:        000, 001, 011, 010,
 *Prefix new entries with 1:                                      110, 111, 101, 100
 *Concatenated:                       000, 001, 011, 010, 110, 111, 101, 100
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> r = s.grayCode(3);
        for (Integer i: r) {
            System.out.println(i);
        }
    }

    public List<Integer> grayCode(int n) {

        if (n==0) {
            List<Integer> r = new ArrayList<Integer>();
            r.add(0);
            return r;
        } else {
            List<Integer> r = grayCode(n-1);
            List<Integer> rr = new ArrayList<>(r);
            Collections.reverse(rr);
            int pre = (int)Math.pow(2, n-1);
            for (Integer i: rr) {
                r.add(i+pre);
            }
            return r;
        }
    }
}

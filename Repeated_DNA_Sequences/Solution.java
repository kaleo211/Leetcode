import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> r = s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String ss: r) {
            System.out.println(ss);
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> r = new ArrayList<String>();

        int len = s.length();
        if (len<=10)
            return r;

        char[] ss = s.toCharArray();
        for (int i=0; i<len; i+=1) {
            if (ss[i]=='A') {
                ss[i] = '0';
            } else if (ss[i]=='T') {
                ss[i] = '1';
            } else if (ss[i]=='G') {
                ss[i] = '2';
            } else if (ss[i]=='C') {
                ss[i] = '3';
            }
        }

        HashSet<Integer> hash = new HashSet<Integer>();
        int front=0, tail=9;
        int val = 0;
        for (int i=0; i<10; i+=1) {
            val = val*4 + (ss[i] - '0');
        }
        hash.add(val);

        int fix = (int)Math.pow(4,9);
        for (int i=1; i<len-9; i+=1) {
            // System.out.println("i: "+i+" val: "+val);
            val = (val - (ss[i-1]-'0')*fix)*4 + (ss[i+9]-'0');
            if (hash.contains(val)) {
                String sub = s.substring(i, i+10);
                if (!r.contains(sub)) {
                    r.add(sub);
                }
            } else {
                hash.add(val);
            }
        }

        return r;
    }
}

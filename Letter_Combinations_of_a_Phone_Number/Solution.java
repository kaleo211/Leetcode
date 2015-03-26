import java.util.List;
import java.util.ArrayList;

public class Solution {


    public static void main(String[] args) {
        List<String> r = new Solution().letterCombinations("7");

        for (String s: r) {
            System.out.println(s);
        }
    }

    public List<String> letterCombinations(String digits) {
        char[] ss = digits.toCharArray();
        int len = ss.length;
        List<String> list = new ArrayList<String>();
        if (len<1) {
            return list;
        }

        char[][] map = new char[][]{{'a', 'b', 'c'},
                                                   {'d', 'e', 'f'},
                                                   {'g', 'h', 'i'},
                                                   {'j', 'k', 'l'},
                                                   {'m', 'n', 'o'},
                                                   {'p', 'q', 'r', 's'},
                                                   {'t', 'u', 'v'},
                                                   {'w', 'x', 'y', 'z'}};

        list.add("");

        for (int i=0; i<len; i+=1) {
            int key = ss[i] - '0' - 2;

            List<String> r = new ArrayList<String>();

            for (String s: list) {
                for (int j=0; j<map[key].length; j+=1) {
                    r.add(s+map[key][j]);
                }
            }

            list = r;
        }

        return list;
    }
}

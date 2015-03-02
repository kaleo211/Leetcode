import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<String> r = new Solution().generateParenthesis(0);
        for (String s: r) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate(n, 0, "", list);
        return list;
    }

    private void generate(int left, int pre, String p, List<String> list) {
        if (left==0 && pre==0) {
            list.add(p);

        } else if (left==0) {
            generate(0, pre-1, p+")", list);

        } else {
            generate(left-1, pre+1, p+"(", list);
            if (pre!=0) {
                generate(left, pre-1, p+")", list);
            }
        }
    }
}

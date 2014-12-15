import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> r = new Solution().generate(5);

        for (List<Integer> list: r) {
            for (Integer i: list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<Integer> cur = new ArrayList<Integer>();
        List<List<Integer>> result = null;
        List<Integer> last = null;


        if (numRows<=0) {
            return new ArrayList<List<Integer>>();
        } else if (numRows==1) {
            result = new ArrayList<List<Integer>>();

        } else {
            cur.add(1);
            result = generate(numRows-1);
            last = result.get(result.size()-1);
            for (int i=1; i<numRows-1; i+=1) {
                cur.add(last.get(i)+last.get(i-1));
            }
        }

        cur.add(1);
        result.add(cur);
        return result;
    }
}

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3,4);
        List<Integer> l3 = Arrays.asList(6,5,7);
        List<Integer> l4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> t = Arrays.asList(l1,l2,l3,l4);
        System.out.println(s.minimumTotal(t));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int height = triangle.size();

        for (int i=height-2; i>=0; i-=1) {
            for (int j=0; j<=i; j+=1) {
                int left = triangle.get(i+1).get(j);
                int right = triangle.get(i+1).get(j+1);
                int shorter = (left > right ? right : left) + triangle.get(i).get(j);
                triangle.get(i).set(j, shorter);
            }
        }

        return triangle.get(0).get(0);
    }
}

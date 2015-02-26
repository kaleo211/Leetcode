import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = new int[] {0, 0};
        System.out.println(s.largestNumber(num));
    }

    public String largestNumber(int[] num) {
        ArrayList<String> nums = new ArrayList<String>();

        int len = num.length;
        int sum = 0;
        for (int i=0; i<len; i+=1) {
            sum += num[i];
            nums.add(Integer.toString(num[i]));
        }
        if (sum==0) {
            return "0";
        }

        Collections.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1+s2, c2 = s2+s1;
                return c2.compareTo(c1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i+=1) {
            sb.append(nums.get(i));
        }
        return sb.toString();
    }
}

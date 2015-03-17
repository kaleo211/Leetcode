import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[] num = new int[]{1,2,4,4};
        System.out.println(new Solution().majorityElement(num));
    }

    public int majorityElement(int[] num) {
        int len = num.length;
        if (len==1) {
            return num[0];
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<len; i+=1) {
            if (!map.containsKey(num[i])) {
                map.put(num[i], 1);
            } else {
                int c = map.get(num[i])+1;
                if (c>len/2) {
                    return num[i];
                } else {
                    map.put(num[i], c);
                }
            }
        }

        return 0;
    }
}

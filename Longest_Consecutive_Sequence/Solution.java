import java.util.Map;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = new int[] {1};
        System.out.println(s.longestConsecutive(num));
    }

    public int longestConsecutive(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int len = num.length;
        int[] l = new int[len];
        boolean[] visited = new boolean[len];

        for (int i=0; i<len; i+=1) {
            map.put(num[i], i);
            l[i] = 1;
        }

        int max = 0;
        for (int i=0; i<len; i+=1) {
            if (!visited[i]) {
                int length = 1;

                int larger = num[i]+1;
                int index;
                while (map.containsKey(larger)) {
                    length += 1;
                    index = map.get(larger);
                    visited[index] = true;
                    larger = num[index]+1;
                }

                int smaller = num[i]-1;
                while (map.containsKey(smaller)) {
                    length += 1;
                    index = map.get(smaller);
                    visited[index] = true;
                    smaller = num[index]-1;
                }

                if (length>max)
                    max = length;
            }
        }

        return max;
    }
}

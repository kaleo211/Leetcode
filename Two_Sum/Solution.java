import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {2, 7, 11, 15};
        int[] result = s.twoSum(numbers, 9);
        System.out.println(result[0]+" "+result[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = numbers.length;
        for (int i=0; i<len; i++) {
            map.put(numbers[i], i);
        }
        int[] nums = new int[2];
        for (int i=0; i<len; i++) {
            int next = target - numbers[i];
            if (map.containsKey(next)) {
                if (map.get(next)!=i) {
                    nums[0] = i+1;
                    nums[1] = map.get(next)+1;
                    break;
                }
            }
        }
        return nums;
    }
}

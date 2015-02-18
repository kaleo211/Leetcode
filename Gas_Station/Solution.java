public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] gas = new int[]{6, 1, 4, 3, 5};
        int[] cost = new int[]{3, 8, 2, 4, 2};

        System.out.println(s.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int[] surplus = new int[len];
        int sum = 0;
        for (int i=0; i<len; i+=1) {
            surplus[i] = gas[i] - cost[i];
            sum += surplus[i];
        }

        // unable to drive a circle
        if (sum<0) {
            return -1;
        }

        int start = 0, index = 0;
        sum = 0;
        for (int i=0; i<2*len; i+=1) {
            index = i % len;
            sum += surplus[index];

            if (sum<0) {
                start = index + 1;
                sum = 0;
            }
        }
        System.out.println("start: "+start);

        return start;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] p = {1,4,2};
        System.out.println(s.maxProfit(p));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length, buy=0;
        if (len==0) return 0;
        int profit=0, pre=0;

        for (int i=1; i<len; i++) {

            if (prices[i]<=prices[buy]) {
                buy = i;
                profit = pre;
            } else {
                if (prices[i]-prices[buy]>pre)
                    profit = prices[i]-prices[buy];
                else
                    profit = pre;
            }
            pre = profit;
            System.out.println("i: "+i+" profit: "+profit);
        }
        return profit;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {};
        System.out.println("profit: "+s.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        int profit=0;
        int length = prices.length;

        for (int i=0, cur=0; i<length-1; ) {
            int j=i+1, buy=i;
            for (; j<length; ) {
                if (prices[j]-prices[j-1]<=0) {
                    buy = j;
                    if (prices[j-1]-prices[i]>0)
                        profit += prices[j-1]-prices[i];
                    break;
                } else if (j==length-1) {
                    buy = j;
                    if (prices[j]-prices[i]>0)
                        profit += prices[j]-prices[i];
                    break;
                } else {
                    j += 1;
                }
            }

            if (buy==j)
                i = buy;
            else
                i += 1;
        }
        return profit;
    }
}

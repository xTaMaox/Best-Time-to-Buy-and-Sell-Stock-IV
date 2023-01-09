class Solution {
    public int maxProfit(int k, int[] prices) {
        // no transaction, no profit
        if (k == 0) return 0;
        // dp[k][0] = min cost you need to spend at most k transactions
        // dp[k][1] = max profit you can achieve at most k transactions
        int [][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) dp[i][0] = 1000;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                // price - dp[i - 1][1] is how much you need to spend
                // i.e use the profit you earned from previous transaction to buy the stock
                // we want to minimize it
                dp[j][0] = Math.min(dp[j][0], prices[i] - dp[j - 1][1]);
                // price - dp[i][0] is how much you can achieve from previous min cost
                // we want to maximize it
                dp[j][1] = Math.max(dp[j][1], prices[i] - dp[j][0]);
            }
        }
        // return max profit at most k transactions
        return dp[k][1];
    }
}
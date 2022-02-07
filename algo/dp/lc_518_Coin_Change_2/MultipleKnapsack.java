public class MultipleKnapsack {
    /*
    背包型DP的多重背包
    状态dp[i][j] 表示前i个数里选，组成和为j的方案个数
    dp[0][0] = 1

    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

    result : dp[n][amount]
     */

    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return 0;
        int n = coins.length;

        int[][] dp = new int[n+1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (j = 0; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i-1]) {
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }
}
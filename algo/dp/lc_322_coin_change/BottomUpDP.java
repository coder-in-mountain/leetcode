public class BottomeUpDP {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        int max = amout + 1;
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coinsj] + 1);
                }
            }
        }
        return dp[amount] > amount ? - 1 : dp[amount];
    }
}

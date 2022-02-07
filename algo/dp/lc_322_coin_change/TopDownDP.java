public class TopDownDP {

    /*
     Time Complexity: O(S*n), where S is the amount, n is denomination count.
     In the worst case the recursive tree of the algorithm has height of S and
     the algorithm solves only S subproblems because it caches precalculated
     solutions in a table. Each subproblme is computed with n iterations,
     one by coin denomination
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        return coinChange(coins, amount, new int[amount]);
    }

    int coinChange(int[] coins, int amount, int[] cache) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (cache[amount - 1] != 0) {
            return cache[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, cache);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amount - 1];
    }
}
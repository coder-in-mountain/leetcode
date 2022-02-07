public class DFS {

    public int change(int amount, int[] coins) {
        int[][] map = new int[coins.length][amount + 1];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], -1);
        }
        return dfs(coins, 0, amount, map);
    }
    int dfs(int[] coins, int i, int amount, int[][] map) {
        if (amount == 0) return 1;
        if (amount < 0 || i == coins.length) {
            return 0;
        }
        if (map[i][amount] != -1) {
            return map[i][amount];
        }
        int res = 0;

        // each coin has two options: choose or not choose
        res += dfs(coins, i+1, amount, map);
        res += dfs(coins, i, amount - coins[i], map);
        map[i][amount] = res
        return res;
    }
}
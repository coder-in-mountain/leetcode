/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
*/
class DPSolution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        /*
         dp[i] is the minimium cost to get to step i.
         After paying cost[i], we can take one or two steps more.
         */
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            int takeOneStep = dp[i-1] + cost[i-1];
            int takeTwoSteps = dp[i-2] + cost[i-1];
            dp[i] = Math.min(takeOneStep, takeTwoSteps);
        }
        return dp[n];
    }
}
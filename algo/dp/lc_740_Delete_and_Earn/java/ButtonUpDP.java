public class ButtonUpDP {
    static final int MAX = 10000;

    public int deleteAndEarn(int[] nums) {
        int[] count = new int[MAX+1];
        int[] dp = new int[MAX+1];
        int maxNum = 0;
        for (int x : nums) {
            count[x]++;
            maxNum = Math.max(maxNum, x);
        }

        for (int i = 1; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i == 1 ? 0 : i - 2] + count[i]*i), dp[i-1]);
        }
        return dp[maxNum];
    }
}
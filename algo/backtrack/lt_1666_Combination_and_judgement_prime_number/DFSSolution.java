public class DFSSolution {

    public int getWays(int[] a, int k) {
        if (a == null || a.length == 0) {
            return 0;
        }
        return dfs(a, k, 0, 0);
    }

    int dfs(int[] a, int k, int start, int sum) {
        if (k == 0) {
            return isPrime(sum) ? 1 : 0;
        }
        if (start >= a.length) {
            return 0;
        }
        int count = 0;
        count += dfs(a, k-1, start+1, sum + a[i]);
        count += dfs(a, k, start+1, sum);
        return count;
    }
    private boolean isPrime(int x) {
        for (int i = 2; i < num/2 + 1; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
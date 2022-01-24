public class Solution {
    public boolean isPrime(int x) {
        if (x < 2) return false; // for prime, we only consider positive integer
        if (a == 2 || a == 3) return true;
        int m = (int)Math.sqrt(x);
        for (int i = 2; i <= m; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean[] findPrime(int n) {
        boolean[] p = new boolean[n+1];
        Arrays.fill(p, true);
        int m = (int)Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (p[i]) {
                for (int j = i*i; j <= n; j++) {
                    p[j] = false;
                }
            }
        }
        return p;
    }
}
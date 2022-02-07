class Solution {

    /*
     Time Complexity : O(n)
     */
    public double mySlowerPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        double ans = 1.0;
        for (long i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
    }

public double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
        x = 1/x;
        N = -N;
    }
    double ans = 1.0;
    double current_product = x;
    for (long i = N; i > 0; i /= 2) {
        if ((i % 2) == 1) {
            ans = ans * current_product;
        }
        current_product = current_product * current_product;
    }
    return ans;
}

}
public class Solution {


    /*
    2.00000
    -2147483648
    will have stackOverflowError caused by myPow(x, -n) since n is an integer. long is required to fix this issue
    */
public double myPow(double x, int n) {
    long N = n;
    return _myPow(x, N);

}

double _myPow(double x, long n) {
    if (n == 0) return 1.0;

    if (n < 0) {
        x = 1/x;
        n = -n;
    }
    double half = _myPow(x, n/2);

    if ((n % 2) == 1) {
        return half * half * x;
    }
    return half * half;
}

}
public Solution {
    public boolean isPowerOfTwo(int x) {
        if (x == 0) return false;
        while (x % 2 == 0) {
            x /= 2;
        }
        return x == 1;
    }

    public boolean isPowerOf2(int x) {
        if (n == 0) return false;
        long x = (long)n;
        return (x & (x-1)) == 0;
    }

    public boolean isPowerOfII(int x) {
        if (n == 0) return false;
        long x = (long)n;
        return (x & (-x)) == x;
    }
}
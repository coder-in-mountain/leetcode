class Solution1 {
    // Time Complexity: O(NLogN)
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> squareDistance(a) - squareDistance(b));
        return Arrays.copyOf(points, 0, k);
    }

    int squareDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
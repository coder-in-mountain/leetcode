class Solution2 {
    // Time Complexity: O(N logK); Space Complexity O(K)
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            int[] entry = {sqaureDistance(points[i]), i};
            maxHeap.add(entry);
        }
        for (int i = k; i < points.length; i++) {
            int[] entry = {sqaureDistance(points[i]), i};

            if (entry[0] < maxHeap.peek()[0]) {
                maxHeap.poll();
                maxHeap.add(entry);
            }
        }
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] entry = maxHeap.poll();
            answer[i] = points[entry[1]];
        }
        return answer;
    }
    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}
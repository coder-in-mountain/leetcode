public class Solution {

    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int n = A.length;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] preSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + A[i];
        }
        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            while (!queue.isEmpty() && (preSum[i] - preSum[queue.peekFirst()]) >= K) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSum[queue.peekLast()] >= preSum[i]) {
                queue.pollLast();
            }
            queue.offer(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
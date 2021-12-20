class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;

        int sum = 0, maxsum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum = Math.max(sum + A[i], A[i]); // if sum < 0, start a new subarray
            maxsum = Math.max(maxsum,sum);
        }
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i-1] + A[i];
        }
        for (int i = n-2; i >= 0; i--) {
            rightSum[i] = A[i] + rightSum[i+1];
        }

        for (int i = 1; i < n; i++) {
            leftSum[i] = Math.max(leftSum[i-1], leftSum[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            rightSum[i] = Math.max(rightSum[i], rightSum[i+1]);
        }

        for (int i = 0; i < n-1; i++) {
            maxsum = Math.max(maxsum, leftSum[i] + rightSum[i+1]);
        }
        return maxsum;
    }
}
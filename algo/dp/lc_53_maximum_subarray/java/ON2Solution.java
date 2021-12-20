class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSubArraySum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubArraySum += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubArraySum);
            }
        }
        return maxSubarray;
    }
}
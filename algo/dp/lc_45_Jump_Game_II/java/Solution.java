class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0,
            n = nums.length,
            steps = 0,
            maxDistance = 0;

        while (i < n) {
            maxDistance = i + nums[i];
            if (maxDistance > 0) {
                steps++;
            }
            if (maxDistance >= n-1) {
                return steps;
            }
            // next, we will decide where to land with the range of maxDistance. In other words, we want to find the max range
            int range = 0;
            for (int j = i+1; j <= maxDistance; j++) {
                if (j + nums[j] > range) {
                    range = j + nums[j];
                    i = j;
                }
            }
        }
        return steps;
    }
}
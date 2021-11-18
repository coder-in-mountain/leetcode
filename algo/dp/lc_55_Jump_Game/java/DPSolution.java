class DPSolution {
    public boolean canJump(int[] nums) {
        int i = 1, n = nums.length, step = nums[0];

        while (i <= step && i < n) {
            step = Math.max(step, i + nums[i]);
            i++;
        }
        return i >= n;
    }
}
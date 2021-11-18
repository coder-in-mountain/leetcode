class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int[] count = new int[10001];
        for (int i : nums) {
            count[i]++;
        }
        int using = 0, avoid = 0, prev = -1;
        for (int i = 1; i <= 10000; i++) {

            int m = Math.max(using, avoid);
            if (count[i] > 0) { // exists
                using = i * count[i] + (prev == i-1 ? avoid : m);
                avoid = m;
                prev = i;
            }
        }
        return Math.max(using, avoid);
    }
}
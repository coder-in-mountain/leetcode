class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int n = intervals.length;
        // min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<>(n, (x, y) -> x - y);
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        allocator.add(intervals[0][1]);

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= allocator.peek()) { // meeting room becomes available
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();

    }
}
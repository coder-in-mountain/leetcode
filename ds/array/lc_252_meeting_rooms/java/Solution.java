class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return true;
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int i = 1;
        while (i < intervals.length) {
            if (intervals[i-1][1] > intervals[i][0]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if( intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int j = i+1;
            while (j < intervals.length && intervals[j][0] <= intervals[i][1]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                j++;
            }
            list.add(intervals[i]);
            i = j;
        }
        return list.toArray(new int[list.size()][]);
    }
}
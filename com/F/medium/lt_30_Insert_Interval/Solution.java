public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) return intervals;
        List<Interval> res = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int insertPos = 0;
        for (Interval itv : intervals) {
            if (itv.end < newInterval.start) {
                res.add(itv);
                insertPos++;
            }else if (itv.start > newInterval.end) {
                results.add(itv);
            }else{
                newInterval.start = Math.min(itv.start, newInterval.start);
                newInterval.end = Math.max(itv.end, newInterval.end);
            }
        }
        res.add(insertPos, newInterval);
        return res;
    }
}
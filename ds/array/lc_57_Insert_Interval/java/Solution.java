class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null) {
            return new int[][]{newInterval};
        }
        int i = 0, n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        boolean done = false;
        while (i < n) {
            if (done) {
                list.add(intervals[i]);
            }else{
                if (newInterval[1] < intervals[i][0]) {
                    list.add(newInterval);
                    list.add(intervals[i]);
                    done = true;
                }else if (newInterval[1] == intervals[i][0]){
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                    list.add(newInterval);
                    done = true;
                }else{
                    if (newInterval[0] <= intervals[i][1]) {
                        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                        int j = i+1;
                        while (j < n && intervals[j][0] <= newInterval[1]) {
                            newInterval[1] = Math.max(newInterval[1], intervals[j][1]);
                            j++;
                        }
                        list.add(newInterval);
                        done = true;
                        i = j-1;
                    }else{
                        list.add(intervals[i]);
                    }
                }
            }

            i++;
        }
        if (!done) {
            list.add(newInterval);
        }
        return list.toArray(new int[list.size()][]);
    }
}
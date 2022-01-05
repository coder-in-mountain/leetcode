import java.util.*;
class TimelineSolution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int n = intervals.length;

        List<Integer> list = new ArrayList<>();
        for (int[] itv : intervals) {
            list.add(itv[0]);
            list.add(-itv[1]);
        }
        Collections.sort(list, (x, y) -> Math.abs(x) - Math.abs(y));

        int count = 0;
        int maxRooms = 0;
        for (int i : list) {
            if (i >= 0) {
                count++;
            }else{
                count--;
            }
            maxRooms = Math.max(maxRooms, count);
        }
        return maxRooms;
    }

    public static void main(String[] args) {
        t(new int[][]{{0, 30}, {5, 10}, {15, 20}});
    }
    static void t(int[][] input) {
        for (int[] itv : input) {
            System.out.print("[" + itv[0] + ", " + itv[1] + "], ");
        }
        System.out.println();
        System.out.println(new TimelineSolution().minMeetingRooms(input));
    }
}
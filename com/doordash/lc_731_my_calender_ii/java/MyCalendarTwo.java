import java.util.*;

public class MyCalendarTwo {
    TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d : map.values()) {
            active +=d;
            if (active >= 3) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }
                return false;
            }
        }
        return true;
    }
}
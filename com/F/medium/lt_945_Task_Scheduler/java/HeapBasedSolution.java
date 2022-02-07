import java.util.*;

public class HeapBasedSolution {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());

        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> coolDownTasks = new ArrayList<>();
            // why n+1 here? n is interval, 1 is the task itself's execution time. so the total execution time of a task is n+1.
            int period = n+1;
            while (period > 0 && !maxHeap.isEmpty()) { // n+1 times

                int task = maxHeap.remove();
                if (task > 1) {
                    coolDownTasks.add(task - 1);
                }
                period--;
                cycles++;
            }
            //cycles += maxHeap.isEmpty() ? coolDownTasks.size() : n + 1;
            if (!coolDownTasks.isEmpty()){
                maxHeap.addAll(coolDownTasks);
            }
            if (!maxHeap.isEmpty() && period > 0) {
                cycles += period;
            }

        }
        return cycles;

    }
}
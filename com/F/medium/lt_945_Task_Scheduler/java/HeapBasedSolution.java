import java.util.*;

public class HeapBasedSolution {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());

        int cycles = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> tasksForNextRound = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int task = maxHeap.remove();
                    if (task > 1) {
                        tasksForNextRound.add(task - 1);
                    }
                }else{
                    break;
                }
            }

            for (int t : tasksForNextRound) {
                maxHeap.add(t);
            }
            cycles += maxHeap.isEmpty() ? tasksForNextRound.size() : n + 1;
            // why n+1 here? n is interval, 1 is the task itself's execution time. so the total execution time of a task is n+1.
        }
        return cycles;
    }
}
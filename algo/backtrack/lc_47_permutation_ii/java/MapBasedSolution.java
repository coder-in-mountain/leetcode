import java.util.*;

public class MapBasedSolution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(new LinkedList<Integer>(),nums.length,  map, res);
        return res;
    }

    void dfs(LinkedList<Integer> comb, int N, Map<Integer, Integer> map, List<List<Integer>> res) {
        if (comb.size() == N) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int e = entry.getKey();
            int count = entry.getValue();

            if (count == 0) continue;

            map.put(e, count - 1);
            comb.addLast(e);
            dfs(comb, N, map, res);

            comb.removeLast(e);
            map.put(e, count);
        }
    }

}
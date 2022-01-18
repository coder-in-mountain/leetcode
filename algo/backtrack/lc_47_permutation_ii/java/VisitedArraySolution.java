import java.util.*;

public class VisitedArraySolution {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, visited, list, res);
        return res;
    }

    void dfs(int[] s, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == s.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (visited[i] || (i > 0 && s[i] == s[i-1] && visited[i-1])) {
                continue;
            }
            visited[i] = true;
            list.add(s[i]);
            dfs(s, visited, list, res);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
import java.util.*;

public class RecursiveSolution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null) return res;

        dfs(num, 0, res);
        return res;
    }

    void dfs(int[] s, int index, List<List<Integer>> res) {
        if (index == s.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : s)
                list.add(i);
            res.add(list);
            return;
        }
        for (int i = index; i < s.length; i++) {
            swap(s, index, i);
            dfs(s, index + 1, res);
            swap(s, index, i);
        }
    }
}
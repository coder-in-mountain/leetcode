public class Solution {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), n, 2);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> list, int n, int start) {
        if (n <= 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i*i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                dfs(res, list, n/i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
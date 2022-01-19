class DFS {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(1, n, k, new ArrayList<Integer>(), res);
        return res;
    }
    void dfs(int start, int end, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (start > end) return;
        list.add(start);
        dfs(start+1, end, k, list, res);
        list.remove(list.size() - 1);
        dfs(start+1, end, k, list, res);
    }
}
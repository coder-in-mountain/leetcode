public class IterativeSolution {

    public List<List<Integer>> permute(int[] num) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        LinkedList<LinkedList<Integer>> res = new LinkedList<>();

        res.add(new LinkedList<Integer>());
        for (int e : nums) {
            int n = res.size();
            while (n-- > 0) {
                LinkedList<Integer> list = res.pollFirst();
                for (int i = 0; i <= list.size(); i++) {
                    LinkedList<Integer> newList = new LinkedList<Integer>(list);
                    newList.add(i, e);
                    res.add(newList);
                }
            }
        }

        return new ArrayList<>(res);
    }
}
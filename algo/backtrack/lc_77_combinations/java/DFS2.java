public class DFS2 {
    /*
    从n个不同元素中，任取m(m≤n)个元素并成一组，叫做从n个不同元素中取出m个元素的一个组合
    n个元素里面挑选k个，可以大致的分为两类：
        第一类，组合的k个元素全部来源于n-1个元素，即这样的组合没有用到或选择第n个元素
        第二类，组合里有用到第n个元素，那么也就相当于剩下的k-1个元素来源于前n-1。
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (n < k || k == 0) return result;

        result = combine(n-1, k-1);
        if (result.isEmpty()) {
            result.add(new LinkedList<Integer>());
        }

        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n-1, k));
        return result;
    }
}
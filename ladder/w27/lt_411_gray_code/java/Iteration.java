public class Iteration {
    // Time Complexity : O(2^n)
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i <= n; i++) {
            int mask = 1 << (i-1);
            int m = list.size();
            for (int j = m-1; j >= 0; j--) {
                list.add(mask + list.get(j));
            }
        }
        return list;
    }
}
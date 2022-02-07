public class RecursiveSolution {

    static final int MAX = 10000;

    public int deleteAndEarn(int[] nums) {
        int[] count = new int[MAX+1];
        int[] cache = new int[MAX+1];
        Set<Integer> visited = new HashSet<>();
        int maxNum = 0;

        for (int x : nums) {
            count[x]++;
            maxNum = Math.max(x, maxNum);
        }
        // 这里处理的方法是从高到低的处理，这样省去一端的逻辑。比如最大值是m，那么我们不需要考虑m+1因为它不存在了。
        return deleteAndEarn(maxNum, count, cache, visited);
    }

    int deleteAndEarn(int num, int[] count, int[] cache, Set<Integer> visited) {
        if (num <= 0) {
            return 0;
        }
        if (!visited.contains(num)) {
            cache[num] = Math.max(
                    deleteAndEarn(num - 2, count, cache, visited) + count[num] * num,
                    deleteAndEarn(nums-1, count, cache, visited));
            visited.add(num);
        }

        return cache[num];
    }
}
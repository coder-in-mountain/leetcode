public class CacheSolution {
    /*
     TC: O(N); SC: O(N)
     */
    Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));

    public int fib(int n) {
        if (!cache.containsKey(n)) {
            cache.put(n, fib(n-1) + fib(n-2));
        }
        return cache.get(n);
    }
}
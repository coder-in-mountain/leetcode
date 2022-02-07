public class DPSolution {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        List<String> res = new ArrayList<>();
        for (String w : words) {
            int n = w.length();
            boolean[] dp = new boolean[n+1];
            Arrays.fill(dp, false);
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                
            }

        }
    }
}
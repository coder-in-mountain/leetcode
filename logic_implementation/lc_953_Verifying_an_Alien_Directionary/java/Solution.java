class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!compare(words[i], words[i+1], j, map)) {
                    return false;
                }
            }
        }
        return true;
    }
    boolean compare(String w1, String w2, int k, int[] index) {
        if (k >= w1.length() || k >= w2.length()) {
            if (w1.length() == w2.length()) {
                return true;
            }
            return w1.length() <= w2.length();
        }
        char c1 = w1.charAt(k);
        char c2 = w2.charAt(k);
        return index[c1-'a'] <= index[c2-'a'];
    }
}
class Solution {

    /*
     * d[i][j] stands for edit distance between w1[0..i] w2[0..j]
     *
     * No Operation: when w1[i-1] == w2[j-1] then d[i][j] = d[i-1][j-1]
     * Operation:
        adding a char to w1 so w1 and w2 can match: d[i][j] = d[i][j-1] + 1
        removing a char from w1 : d[i][j] = d[i-1][j] + 1
        replace a char : d[i][j] = d[i-1][j-1] + 1
     */
    public int minDistance(String w1, String w2) {
        if (w1 == null && w2 == null) return 0;
        int n = w1.length(), m = w2.length();

        int[][] d = new int[n+1][m+1];

        d[0][0] = 0;
        for (int i = 0; i < n+1; i++)
            d[i][0] = i;
        for (int j = 0; j < m+1; j++)
            d[0][j] = j;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                d[i][j] = Math.min(d[i-1][j], d[i][j-1]) + 1;
                if (w1.charAt(i-1) == w2.charAt(j-1)) {
                    d[i][j] = Math.min(d[i][j], d[i-1][j-1]);
                }else{
                    d[i][j] = Math.min(d[i][j], d[i-1][j-1] + 1);
                }
            }
        }
        return d[n][m];
    }
}
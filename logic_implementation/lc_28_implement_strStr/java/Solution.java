class Solution {
    // time complexity: haystack N, needle M
    // O(N*M)
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            while (j < needle.length() && i+j < haystack.length() && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
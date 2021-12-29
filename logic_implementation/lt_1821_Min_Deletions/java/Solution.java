public class Solution {
    /* https://www.lintcode.com/problem/1821/
       给定一个字符串s，只含A和B两种字符，求从s中删除若干字符，使得s成为若干A后面接若干B的格式。问至少要删多少个字符

       此类题目（把字符串左面归位一种模式，右边安排为另外一种模式），主要一种思路是选定从哪里分割左右。而左右分割的方法可以采取暴力枚举就好。

       本体中允许的操作仅有删除操作。所以如果选定从i点分割，那么[0..i-1]中的B即是删除的B的个数，[i..n-1]中A的个数则是需要删除的A的个数。

       通过枚举i的位置，然后取最小值即可求解
    */
    public int minDeletions(String s) {
        if (s == null || s.length() == 0) return 0;
        int leftB = 0, rightA = 0;
        char[] chs = s.toCharArray();
        for (char c : chs){
            if (c == 'A')
                rightA++;
        }
        int minDeletions = rightA;
        for (char c : chs){
            if (c == 'A') {
                rightA -= 1;
            }else{
                leftB += 1;
            }
            minDeletions = Math.min(minDeletions, leftB + rightA);
        }
        return minDeletions;
    }
}
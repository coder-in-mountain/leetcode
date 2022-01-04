public class StackSolution {

    /*
    A must be put in the left of all Bs.
    AABA ->
    stack = [B] <- A, delete b so that we have all As. AAA
    BA ->
    Stack = [B] <- A, same
    BAA
    BAAAA
    aa[ba]b[ba]b -> aaabbb
                 -> aabbbb

         passed    stack
          aab        [b]
          aab        [] +1
          aababb     [bb]
          aababba    [b] +1
          aababbab   [bb]

    AB


     */
    public int minimumDeletions(String s) {
        int deletions = 0;

        int bCount = 0;
        for (char ch : s.toCharArray()) {
            if (bCount > 0 && ch == 'a') {
                bCount--;
                deletions++;
            }else if (ch == 'b') {
                bCount++;
            }
        }
        return deletions;
    }
}
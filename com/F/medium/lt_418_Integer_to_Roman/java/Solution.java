import java.util.*;

public class Solution {
    /**
1   2	3	4	5	6	7	8	 9	10	11	12
I, II, III, IV, V, VI, VII, VIII, IX, X, XI, XII

1 		I
5 		V
10 		X
50 		L
100 	C
500 	D
1000 	M
     */

    static char[][] table = {
        // one, five, ten
        {'M', '0', '0'},
        {'C', 'D', 'M'},
        {'X', 'L', 'C'},
        {'I', 'V', 'X'}
    };

    static int[] scale = {1000, 100, 10, 1};

    public String intToRoman(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            toRoman(n/scale[i] % 10, table[i], sb);
        }
        return sb.toString();
    }

    void toRoman(int n, char[] table, StringBuilder sb) {
        if (n == 9) { // append one and ten
            sb.append(table[0]).append(table[2]);
        }else if (n >= 5) {
            sb.append(table[1]).append(String.join("", Collections.nCopies(n-5, String.valueOf(table[0]))));
        }else if (n == 4) {
            sb.append(table[0]).append(table[1]);
        }else{
            sb.append(String.join("", Collections.nCopies(n, String.valueOf(table[0]))));
        }
    }
}
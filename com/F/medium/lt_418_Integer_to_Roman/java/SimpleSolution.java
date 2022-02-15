public class SimpleSolution {
    // Symbol       Value
    // I             1
    // V             5
    // X             10
    // L             50
    // C             100
    // D             500
    // M             1000

    static final String[][] map = {
        {"", "M", "MM", "MMM", "-1", "-1", "-1","-1", "-1", "-1"}, //>=1000
        {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, //>= 100
        {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, //>= 10
        {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}  //>= 0
    };
    static final int[] scale = {1000, 100, 10, 1};
    public String intToRoman(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scale.length; i++) {
            sb.append(map[i][n/scale[i]]);
            n %= scale[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        t(6);
        t(16);
        t(266);
        t(2666);
    }

    static void t(int n) {
        System.out.printf("%d -> %s\n", n, new SimpleSolution().intToRoman(n));
    }
}
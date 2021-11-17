public class Solution{
    static String[] under20 = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] under100 = {
            "", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    static String[] multiplierName = {"", " Hundred", " Thousand", " Million", " Billion"};
    static int[] multiplierUnit    = {1,   100,         1000,       1000000,    1000000000};
    public String numberToWords(int num) {
        return toWords("", num);
    }

    String toWords(String prev, int num) {
        if (num == 0) {
            return prev.length() == 0 ? "Zero" : prev;
        }
        if (num < 20) {
            return prev.length() == 0 ? under20[num] : prev + " " + under20[num];
        }
        if (num < 100) {
            String answer = toWords(under100[num/10], num % 10);
            return prev.length() == 0 ? answer : prev + " " + answer;
        }
        if (num < 1000) {
            String answer = toWords(prev, num / 100) + " Hundred";
            return toWords(answer, num % 100);
        }
        int n = Integer.toString(num).length();
        int index = (int)Math.ceil(n/3.0);

        String answer = toWords(prev, num / multiplierUnit[index]) + multiplierName[index];
        return toWords(answer, num % multiplierUnit[index]);
    }

    public static void main(String[] args) {
        t(12345);
        t(123456780);
    }
    static void t(int n) {
        System.out.printf("%d -> %s\n", n, new Solution().numberToWords(n));
    }
}
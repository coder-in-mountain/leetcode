public class Solution {
    public String convert(long index) {
        index--;
        long pageCount = index / 702 + 1;
        StringBuilder sb = new StringBuilder();

        sb.append(Long.toString(pageCount));

        index %= 702;

        int div = (int)index/26;
        int remain = (int)index % 26;

        if (div > 0) {
        result.append((char)('A' - 1 + div));
        result.append((char)('A' + remain));
        return result.toString();
    }
}

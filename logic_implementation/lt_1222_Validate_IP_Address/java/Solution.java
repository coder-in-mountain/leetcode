public class Solution {
    /**
     * @param IP: the given IP
     * @return: whether an input string is a valid IPv4 address or IPv6 address or neither
     */
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) return "Neither";
        if (IP.contains(".") && isValidIP4(IP)) return "IPv4";
        if (IP.contains(":") && isValidIP6(IP)) return "IPv6";
        return "Neither";
    }

    boolean isValidIP4(String ip) {
        String[] s = ip.split("\\.");

        if (s.length != 4) return false;
        for (String str : s) {
            if (!isValidIP4Segment(str)) {
                return false;
            }
        }
        return true;
    }

    boolean isValidIP6(String ip) {
        String[] s = ip.split(":");
        if (s.length != 8) return false;
        for (String str : s) {

            if (!isValidIP6Segment(str)) {
                return false;
            }
        }
        return true;
    }

    boolean isValidIP4Segment(String s) {
        int n = s.length();
        if (n == 0 || (n > 1 && s.charAt(0) == '0')) return false;
        if (n > 3) return false;
        int sum = 0;
        for (char ch : s.toCharArray()) {
            if (ch < '0' || ch > '9')
                return false;
            sum = sum * 10 + (ch - '0');
        }
        return sum <= 255;
    }


    boolean isValidIP6Segment(String s) {
        int n = s.length();

        if (n > 4) return false;
        int i = 0;

        while (i < n && s.charAt(i) == '0') {
            i++;
        }

        while (i < n) {
            char ch = s.charAt(i);
            if (!(Character.isDigit(ch) || (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f'))) {
                return false;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        t("172.16.254.1");
        t("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
        t("2001:0db8:85a3::8A2E:0370:7334");
        t("256.256.256.256");
    }

    static void t(String s) {

        String[] str = s.split(":");
        System.out.printf("%s, %d\n", s, str.length);

        System.out.println(new Solution().validIPAddress(s));
    }
}
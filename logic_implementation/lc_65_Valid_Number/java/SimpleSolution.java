public class SimpleSolution {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        int expIndex = Math.max(s.indexOf('e'), s.indexOf('E'));
        if (expIndex != -1) {
            return isDecimalOrInteger(s.substring(0, expIndex)) && isInteger(s.substring(expIndex + 1));
        }
        return isDecimalOrInteger(s);
    }

    boolean isDecimalOrInteger(String s) {
        int dotIndex = s.indexOf('.');
        if (dotIndex != -1) {
            return isInteger(s.substring(0, dotIndex)) && (dotIndex + 1 == s.length() || isInteger(s.substring(dotIndex + 1)));
        }
        return isInteger(s);
    }

    boolean isInteger(String s, boolean canHaveSign) {
        char[] chs = s.toCharArray();
        boolean hasSign;
        int i = 0, n = chs.length;
        if (i < n && (chs[i] == '+' || chs[i] == '-')) {
            if (!canHaveSign) {
                return false;
            }
            hasSign = true;
            i++;
        }
        while (i < n)
            if (!Character.isDigit(chs[i])) {
                return false;
            }
            i++;
        }
        return hasSign ? i > 1 : i > 0;
    }

    public static void main(String[] args) {
        t(".1");
        t(".");
        t("0.");
    }
}
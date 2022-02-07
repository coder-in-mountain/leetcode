class Solution {
     public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();

        if (s.length() > 0 && isSign(s.charAt(0))) {
            s = s.substring(1);
        }
        if (s.length() == 0) return false;
        int expIndex = Math.max(s.indexOf("e"), s.indexOf("E"));
        if (expIndex != -1) {
            String left = s.substring(0, expIndex);

            if (expIndex + 1 < s.length() && isSign(s.charAt(expIndex + 1))){
                expIndex++;
            }

            String right = s.substring(expIndex + 1);
            return isInteger(right) && isDecimalOrInteger(left);
        }
        return isDecimalOrInteger(s);
    }
    boolean isSign(char ch) {
        return ch == '+' || ch == '-';
    }

    boolean isDecimalOrInteger(String s) { // corner case .123 and 123.
        int dotIndex = s.indexOf(".");
        if (dotIndex != -1) {
            if (0 == dotIndex) { // .12
                return isInteger(s.substring(dotIndex + 1));
            }
            if (dotIndex + 1 == s.length() ) { // 123.
                return isInteger(s.substring(0, dotIndex));
            }
            return isInteger(s.substring(0, dotIndex)) && isInteger(s.substring(dotIndex + 1));
        }
        return isInteger(s);
    }

    boolean isInteger(String s) {
        if (s == null || s.length() == 0) return false;
        boolean seenDigit = false;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
            seenDigit = true;
        }
        return seenDigit;
    }
}
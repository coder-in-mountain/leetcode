import java.util.*;
public class Solution {

    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        boolean blockCommentStart = false;
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                String str = s.substring(right, Math.min(s.length(), right+2));
                if (!blockCommentStart) {

                    if (str.equals("//")) {
                        sb.append(s.substring(left, right));
                        left = s.length();
                        break;
                    }else if (str.equals("/*")) {
                        blockCommentStart = true;
                        sb.append(s.substring(left, right));
                        right+=1;
                    }
                }else{ //blockCommentStart == true
                    if (str.equals("*/")) {
                        blockCommentStart = false;
                        right+=1;
                        left = right+1;
                    }
                }
            }
            if (!blockCommentStart) {
                if (left < s.length()) {
                    sb.append(s.substring(left));
                }
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        t(new String[]{
            "ab/* fdafd */cd",
            "//abc/*",
            "a/*fdafda*/bcd//fdafdaf"
        });
        t(new String[]{
        "/*Test program */",
        "int main()",
        "{ ",
        "  // variable declaration ",
        "int a, b, c;",
        "/* This is a test",
        "   multiline  ",
        "   comment for ",
        "   testing */",
        "a = b + c;", "}"
        });

    }
    static void t(String[] source) {
        List<String> list = new Solution().removeComments(source);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();
    }

}
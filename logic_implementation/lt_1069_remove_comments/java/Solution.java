import java.util.*;
public class Solution {

    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        boolean blockCommentStart = false;
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            int left = 0;
            int right = 0;
            
            while (right + 1 < s.length()) {
                String str = s.substring(right, right+2);
                if (!blockCommentStart) {

                    if (str.equals("//")) {
                        sb.append(s.substring(left, right));
                        right = s.length();
                        left = right;
                        break;
                    }else if (str.equals("/*")) {
                        blockCommentStart = true;
                        sb.append(s.substring(left, right));
                        right+=2;
                        // do we need to move left?
                        left = right;
                        continue;
                    }else{
                        right++;
                    }

                }else{ //blockCommentStart == true
                    if (str.equals("*/")) {
                        blockCommentStart = false;
                        right+=2;
                        left = right;
                    }else{
                        right++;
                        left++;
                    }
                }
            }
            if (!blockCommentStart && left < s.length()) {
                sb.append(s.substring(left));
            }
            if (!blockCommentStart && sb.length() > 0) {
                list.add(sb.toString());
                sb = new StringBuilder();
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
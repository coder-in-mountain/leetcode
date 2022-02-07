public class Solution {

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        int result = 0, operand = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case ' ': break;
                case '+':
                    result += sign * operand;
                    operand = 0;
                    sign = 1;
                    break;
                case '-':
                    result += sign * operand;
                    operand = 0;
                    sign = -1;
                    break;
                case '(':
                    stack.push(result);
                    stack.push(sign);
                    sign = 1;
                    result = 0;
                    break;
                case ')':
                    result += sign * operand;
                    operand = 0;
                    result *= stack.pop(); // the top of stack is the sign
                    result += stack.pop();
                    break;
                default:
                    if (Character.isDigit(ch)) {
                        operand = 10 * operand + (int)(ch - '0');
                    }
            }
        }
        if (operand != 0) result += sign * number;
        return result;
    }
}
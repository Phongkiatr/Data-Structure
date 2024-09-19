package solutions.pack5_Postfix;

import java.util.regex.Pattern;
import java.util.Stack;

public class MyRPN {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
        String[] tokens = rpn.split(" ");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.valueOf(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double result;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }
}

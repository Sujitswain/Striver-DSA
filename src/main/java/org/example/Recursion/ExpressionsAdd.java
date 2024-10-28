package org.example.Recursion;
import java.util.ArrayList;
import java.util.List;

class ExpressionsAdd {
    public static List<String> addOperators(String num, int target) {
        List<String> results = new ArrayList<>();
        backtrack(num, target, "", 0, 0, 0, results);
        return results;
    }

    private static void backtrack(String num, int target, String expression, int index, long calculated, long lastOperand, List<String> results) {
        if (index == num.length()) {
            if (calculated == target)
                results.add(expression);
            return;
        }

        for (int i = index; i < num.length(); i++) {

            String currentStr = num.substring(index, i + 1);

            // multiplication it becomes 0
            if (currentStr.length() > 1 && currentStr.charAt(0) == '0')
                continue;

            long currentNum = Long.parseLong(currentStr);

            if (index == 0)
                backtrack(num, target, currentStr, i + 1, currentNum, currentNum, results);

            else {
                backtrack(num, target, expression + "+" + currentStr, i + 1,
                        calculated + currentNum, currentNum, results);

                backtrack(num, target, expression + "-" + currentStr, i + 1,
                        calculated - currentNum, -currentNum, results);

                backtrack(num, target, expression + "*" + currentStr, i + 1,
                        calculated - lastOperand + (lastOperand * currentNum), lastOperand * currentNum, results);
            }
        }
    }

    public static void main(String[] args) {
        addOperators("123", 6);
        // addOperators("232", 8);
    }
}

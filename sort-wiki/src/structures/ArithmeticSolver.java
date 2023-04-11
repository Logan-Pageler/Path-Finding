package structures;

/**
 * Program that uses a stack to solve arithmetic.
 * 
 * @author Logan Pageler
 * @since 4/10/2023
 */
public class ArithmeticSolver {

    /**
     * Evaluates an expression and returns the value
     * 
     * @param expression expression string to evaluate
     * @return Expression output
     */
    public static int evaluate(String expression) {
        Stack<Integer> operands = new Stack<>(); // Operand stack
        Stack<Character> operations = new Stack<>(); // Operator stack
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {

                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < expression.length()) {
                        c = expression.charAt(i);
                    } else {
                        break;
                    }
                }
                i--;
                operands.push(num);
            } else if (c == '(') {
                operations.push(c);
            }

            else if (c == ')') {
                while (operations.peek() != '(') {
                    int output = performOperation(operands, operations);
                    operands.push(output);
                }
                operations.pop();
            }

            else if (isOperator(c)) {
                while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) {
                    int output = performOperation(operands, operations);
                    operands.push(output);
                }
                operations.push(c);
            }
        }

        while (!operations.isEmpty()) {
            int output = performOperation(operands, operations);
            operands.push(output);
        }
        return operands.pop();
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static int performOperation(Stack<Integer> operands, Stack<Character> operations) {
        int a = operands.pop();
        int b = operands.pop();
        char operation = operations.pop();
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0) {
                    System.out.println("Cannot divide by zero");
                    return 0;
                }
                return b / a;
        }
        return 0;
    }

    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
    }
}

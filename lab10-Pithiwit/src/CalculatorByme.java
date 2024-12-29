class Calculator {

    public static int evaluateExpression(String expression) throws Exception {
        String[] tokens = expression.split("(?=[+\\-*/%])|(?<=[+\\-*/%])");
        if (tokens.length < 3 || tokens.length % 2 == 0) {
            throw new Exception("Malformed expression");
        }

        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result /= operand;
                    break;
                case "%":
                    result %= operand;
                    break;
                default:
                    throw new Exception("Unsupported operator: " + operator);
            }
        }

        return result;//
    }
}

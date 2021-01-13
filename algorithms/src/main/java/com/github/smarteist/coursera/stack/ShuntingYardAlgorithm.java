package com.github.smarteist.coursera.stack;

public class ShuntingYardAlgorithm {

    public static Double calculate(String s) {
        LinkedListStack<Double> vals = new LinkedListStack<>(); // Values stack
        String[] tokens = infixToPostfix(s).split("");  // read input and store it as array of strings delimited by spaces
        // take one token at a time
        for (String token : tokens) {
            if (isOperator(token.charAt(0))) {
                if (token.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (token.equals("-")) {
                    Double pop = vals.pop();
                    vals.push(vals.pop() - pop);
                }
                else if (token.equals("/")) {
                    Double pop = vals.pop();
                    vals.push(vals.pop() / pop);
                } else if (token.equals("*")) vals.push(vals.pop() * vals.pop());

            } else {
                vals.push(Double.parseDouble(token));
            }
        }
        return vals.pop();
    }

    public static String infixToPostfix(String infix) {
        String postfix = "";
        LinkedListStack<Character> operator = new LinkedListStack<>();
        char popped;

        for (int i = 0; i < infix.length(); i++) {
            char get = infix.charAt(i);
            if (!isOperator(get))
                postfix += get;
            else if (get == ')') {
                while ((popped = operator.pop()) != '(')
                    postfix += popped;
            } else {
                while (!operator.isEmpty() && get != '(' && precedence(operator.peek()) >= precedence(get))
                    postfix += operator.pop();
                operator.push(get);
            }
        }
        // pop any remaining operator
        while (!operator.isEmpty())
            postfix += operator.pop();
        return postfix.replaceAll("\\s", "");
    }

    private static boolean isOperator(char i) {
        return precedence(i) > 0;
    }

    private static int precedence(char i) {

        if (i == '(' || i == ')') return 1;
        else if (i == '-' || i == '+') return 2;
        else if (i == '*' || i == '/') return 3;
        else return 0;
    }
}

package calculator;

import exception.InvalidOperatorException;
import interpreter.Interpreter;

import java.util.LinkedList;

public enum  PrimeCalculator {
    GENERAL;
    private LinkedList<String> expression = new LinkedList<>();
    private int bracketCount(String expression)
    {
        int result = 0;
        for (int i = 0; i < expression.length() ; i++) {
            if(expression.charAt(i)=='(')
            {
                result++;
            }
        }
        return result;
    }
    public String defineExpression(String word) throws InvalidOperatorException {
        while(bracketCount(word)!=0) {
            int brackets = bracketCount(word);
            int i = 0, j = 0;
            while (i < brackets) {
                if (word.charAt(j) == '(') {
                    i++;
                }
                j++;
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (word.charAt(j) == ')') {
                    break;
                }
                sb.append(word.charAt(j));
                j++;
            }
            String result = Interpreter.GENERAL.count(sb.toString());
            word = word.replace("(" + sb.toString() + ")", result);
        }
        return word;
    }
}

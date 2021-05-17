package calculator;

import exception.InvalidOperatorException;

public enum BinaryCalculator {
    GENERAL;
    public String count(int first, int second, String operator) throws InvalidOperatorException {
        int result;
        switch (operator)
        {
            case "|":
            {
                result=first|second;
                break;
            }
            case "&":
            {
                result=first&second;
                break;
            }
            case"<":
            {
                result=first<<second;
                break;
            }
            case">":
            {
                result=first>>second;
                break;
            }
            case "~":
            {
                result=~first;
                break;
            }
            default:
            {
                throw new InvalidOperatorException("Unknown operator");
            }
        }
        return Integer.toString(result);
    }
}

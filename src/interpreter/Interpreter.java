package interpreter;

import calculator.BinaryCalculator;
import exception.InvalidOperatorException;

public enum Interpreter {
    GENERAL;
    private String operators="^|&>><<~";
    private String firstOperand;
    private String secondOperand;
    private String operator;

    //дописать сохранение знаков препинания на конце слов
    private void parseOperation(String word)
    {
        int counter=0;
        StringBuilder sb = new StringBuilder();
        //добавить возможность для двусимвольных операторов
        if(operators.indexOf(word.charAt(0))!=-1)
        {
            operator=Character.toString(word.charAt(0));
            for (int i = 1; i <word.length() ; i++) {
                sb.append(word.charAt(i));
            }
            firstOperand=sb.toString();
            secondOperand="p";
        }
        else {
            for (int i = 0; i < word.length(); i++) {
                if (operators.indexOf(word.charAt(i)) == -1) {
                    sb.append(word.charAt(i));
                } else {
                    if (counter == 0) {
                        firstOperand = sb.toString();
                        operator = Character.toString(word.charAt(i));
                        counter++;
                    }
                    sb = new StringBuilder();
                }
            }
            secondOperand = sb.toString();
        }
    }
    public String count(String word) throws InvalidOperatorException {
        parseOperation(word);
        int first = Integer.parseInt(firstOperand);
        if(secondOperand!="p") {
            int second = Integer.parseInt(secondOperand);
            return BinaryCalculator.GENERAL.count(first, second, operator);
        } else
        {
            return BinaryCalculator.GENERAL.count(first, 0, operator);
        }
    }
}

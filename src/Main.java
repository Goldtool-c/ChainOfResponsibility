import calculator.PrimeCalculator;
import exception.InvalidOperatorException;
import interpreter.Interpreter;

public class Main {
    public static void main(String[] args) throws InvalidOperatorException {
        System.out.println(Interpreter.GENERAL.count("5&8|9"));
    }
}

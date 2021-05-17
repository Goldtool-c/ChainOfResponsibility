import exception.InvalidOperatorException;
import interpreter.Interpreter;

public class Main {
    public static void main(String[] args)
    {
        try {
            System.out.println(Interpreter.GENERAL.count("5|3"));
        } catch (InvalidOperatorException e) {
            e.printStackTrace();
        }
    }
}

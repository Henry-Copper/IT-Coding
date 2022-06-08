import java.util.Scanner;

import static java.lang.Double.NaN;
import static java.lang.Double.isFinite;

public class Main {

    public static void main(String[] args){

        double calculated;
        do{
            System.out.print("Please enter an expression to evaluate (note, you cannot use brackets): ");
            calculated = Expressions.evaluateNumericalExpression(new Scanner(System.in).nextLine());
        }
        while (Double.isNaN(calculated));
        {
            System.out.print("You entered something incorrectly, try again: ");
            calculated = Expressions.evaluateNumericalExpression(new Scanner(System.in).nextLine());
        }
        System.out.println(calculated);

    }
}

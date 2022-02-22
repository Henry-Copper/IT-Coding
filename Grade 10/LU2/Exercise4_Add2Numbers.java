// H Klopper 22 February 2022 LU2_Exercise4

import javax.swing.*;

public class Exercise4_Add2Numbers
{

   public static void main (String[] args)
   {
   
   double num1 = Double.parseDouble(JOptionPane.showInputDialog("Type the first number"));
   double num2 = Double.parseDouble(JOptionPane.showInputDialog("Type the second number"));

   System.out.println("The sum of the number is " + (num1 + num2));
   
   // Java sees the number as a double, throws an error as you are typecasting the double to a smaller memory space (float)
//float number1 = 3.021012012913947891843;

// this runs, putting a float in a float
float number2 = Float.parseFloat("3.021012012913947891843");
System.out.println(number2);

// also runs as Java sees this as a float
number2 = 3.021012012913947891843f;

// Java assumes a decimal number is a double; may omit the d
double number3 = 3.021012012913947891843d;
number3 = 3.021012012913947891843;


   // System.out.println(number1);
   System.out.println(number2);
   System.out.println(number3);
   
   // this displays in scientific notation; what?
   double largeSmall = 0.00000000000032;
   System.out.println(largeSmall);

   // displays with a decimal place, integer stored as a double
   double integer = 5;
   System.out.println(integer);
   } // main method

} // Exercise4_Add2Numbers class
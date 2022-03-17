// H Klopper 16 March 2022 LU2_Activity7

import javax.swing.*;

public class Activity7_VarValues
{

   public static void main(String[] args)
   {
   
   // Declaring variables
   int num1, num2, num3;
   
   // Assigning values to variables
   num1 = 7;
   num2 = 15;
   
   // Getting a value into a variabe from the keyboard
   String message = "Type in any integer and <Enter>: ";
   num3 = Integer.parseInt(JOptionPane.showInputDialog(message));
   
   // Displaying output
   System.out.println();
   System.out.println("The first integer is " + num1);
   System.out.println("The second integer is " + num2);
   System.out.println("The thirst integer is " + num3);
   
   // Declaring and assigning in one statement
   int sum = num1 + num2 + num3;
   
   // More output
   System.out.println("The sum of the 3 integers is " + sum);
   
   // Product of the three integers
   int product = num1 * num2 * num3;
   System.out.println("The product of the 3 integers " + product);
   
   
   } // main method

} // Activity7_VarValues class
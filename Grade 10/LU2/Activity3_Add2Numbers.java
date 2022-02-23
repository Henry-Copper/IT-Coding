// H Klopper 10 February 2022 LU2_Activity3

import javax.swing.*;

public class Activity3_Add2Numbers
{

   public static void main(String[] args)
   {
   
   // use try catch block to screen input?
   
   int num1 = Integer.parseInt(JOptionPane.showInputDialog("Type the first number"));
   int num2 = Integer.parseInt(JOptionPane.showInputDialog("Type the second number"));
   
   // have to put the integers in brackets to ensure they are added to each other, not just concatenated to the string from left to right

   System.out.println("The sum of the number is " + (num1 + num2));
  
  
  String test1 = "hello";
  String test2 = "yes";
   String test3 = "four";
  
  // doesn't matter in what order you concatenate; this runs 
   System.out.println(test1 + (test2 + test3)); 
   } // main method

} // Activity3_Add2Numbers class

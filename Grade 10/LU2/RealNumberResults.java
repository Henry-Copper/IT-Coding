// H Klopper 2 March 2022 LU2_Exercise2

import javax.swing.*;

public class RealNumberResults
{

   public static void main(String[] args)
   {
   
   double inputNumber1 = Double.parseDouble(JOptionPane.showInputDialog("Please enter any whole number"));
   double inputNumber2 = Double.parseDouble(JOptionPane.showInputDialog("Please enter another whole number"));
   
   double outputNumber = inputNumber1 * inputNumber2;
   
   System.out.println("The first inputted number was: " + inputNumber1);
   System.out.println("The second inputted number was: " + inputNumber2);
   System.out.println("The number doubled is: " + outputNumber);
   
   }

}
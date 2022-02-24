// H Klopper 23 February 2022 LU2_Exercise2

import javax.swing.*;

public class Exercise2_Prices
{

   public static void main (String[] args)
   {
   
   // declare variables
   String product1, product2, product3;
   double price1, price2, price3;
   
   // ask for user inputs
   product1 = JOptionPane.showInputDialog("Please type in the first product's name");
   price1   = Double.parseDouble(JOptionPane.showInputDialog("Please type in the first product's price"));
  
   product2 = JOptionPane.showInputDialog("Please type in the second product's name");
   price2   = Double.parseDouble(JOptionPane.showInputDialog("Please type in the second product's price"));
  
   product3 = JOptionPane.showInputDialog("Please type in the third product's name");
   price3   = Double.parseDouble(JOptionPane.showInputDialog("Please type in the third product's price"));
     
   // display shopping list
   System.out.println("\nSHOPPING LIST");
   System.out.println(String.format("%-15s %s", product1, price1));
   System.out.println(String.format("%-15s %s", product2, price2));
   System.out.println(String.format("%-15s %s", product3, price3));
   System.out.println(String.format("%-15s %s", "TOTAL COST:", (price1 + price2 + price3)));
  
   } // main method

} // Exercise2_Prices class
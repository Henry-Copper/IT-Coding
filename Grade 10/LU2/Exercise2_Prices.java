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

// why display a blank line?   
     
     // display shopping list
// why display a blank line?   
     System.out.println("\n SHOPPING LIST");
     System.out.println(String.format("%10s", product1 + "\t" + price1));
     System.out.println(String.format("%10s", product2 + "\t" + price2));
     System.out.println(String.format("%10s", product3 + "\t" + price3));
   
   } // main method

} // Exercise2_Prices class
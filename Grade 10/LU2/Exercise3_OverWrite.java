// H Klopper 9 March 2022 LU2_Exercise3

import javax.swing.*;

public class Exercise3_OverWrite
{

   public static void main(String[] args)
   {
   
   int num;
   
   // OverWrite 1
   num = 4;
   System.out.println("num is " + num);
   num = 10;
   System.out.println("num is " + num);
   
   // OverWrite 2
   num = 4;
   num = 10;
   System.out.println("\nnum is " + num);
   
   // OverWrite 3
   num = 4;
   System.out.println("\nnum is " + num);
   num = 10;
   
   // Overwrite 4
   num = 4;
      System.out.println("\nnum is " + num);
num = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
     System.out.println("num is " + num);

   }

}
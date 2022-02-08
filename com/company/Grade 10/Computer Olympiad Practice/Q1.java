// Q1 Heinrich Klopper, username, openjdk 11.0.13

import java.util.*;

public class Q1
{

   public static void main(String[] args)
   {
   
   // okay but like space-separated
   
   Scanner scanner = new Scanner(System.in);
   
   System.out.print("Input the first number: ");
   int number1 = scanner.nextInt();
   
   System.out.print("Input the second number: ");
   int number2 = scanner.nextInt();

   System.out.print("Input the third number: ");
   int number3 = scanner.nextInt();
   
   System.out.print("Input the fourth number: ");
   int number4 = scanner.nextInt();
   
   System.out.println(number1 * number4 - number2 * number3);
   }

}
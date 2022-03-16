// H Klopper 16 March 2022 LU2_Activity7

public class Activity6_Incrementing
{

   public static void main(String[] args)
   {
   
   int num1 = 7;
   int num2 = 10;
   
   System.out.println("The first integer is " + num1);
   System.out.println("The second integer is " + num2);
   
   num1++;
   // this doesn't generate an error
   num2 = num2++;
   
   System.out.println("After incrementing:");
   System.out.println("The integer is now " + num1);
   System.out.println("The second integer is now " + num2);
   
   num1--;
   num2--;
   
   System.out.println("After decrementing:");
   System.out.println("The integer is now " + num1);
   System.out.println("The second integer is now " + num2);
   
   // but aren't strings supposed to be special?
   String test = "hello";
   test += "yes";
   System.out.println(test);
   
   double first = 5 % 3;
   System.out.println(first);
   int second = 5 % 3;
   System.out.println(second);
   
   } // main method

} // Activity6_Incrementing class
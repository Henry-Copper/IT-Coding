// H Kopper 11 May 2022 LU3_Activity3

public class Activity3_Strings
{

   public static void main (String [] args)
   {
   
   String s1 = "hello";
   String s2 = "there";
   System.out.println(s1 + ' ' + s2); // one space between ' '
   String s3 = "Line 1\nLine2";
   System.out.println(s3);
   String wrd = "" + s2.charAt(0)+s1.charAt(4);
   
   System.out.println(wrd);
   char ch = s2.charAt(3);
   System.out.println(ch);
   
   }

}
// H Klopper 13 May 2022 LU3_Activity5
import javax.swing.*;
import java.util.ArrayList;

public class Activity5_StringLengths
{

   public static void main (String[] args)
   {
   // initial step
    ArrayList<String> commands = new ArrayList<>();
    commands.add("Please enter a name");
    commands.add("Please enter another name");
    commands.add("Please enter a comment");

   for (String string : commands){
       String temp = JOptionPane.showInputDialog(string);
       System.out.println(buildString(temp));
       System.out.println(temp.charAt(0));
   }

   } // main method
   
   private static String buildString(String str){
   
   return "\n\"" + str + "\" has " + str.length() + " characters in it ";
   
   } // buildString method

} // Activity5_StringLengths class
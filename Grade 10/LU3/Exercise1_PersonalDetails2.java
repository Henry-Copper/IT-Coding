// H Klopper 22 March 2022 LU3_Exercise1

import javax.swing.*;
import java.util.*;
import java.awt.Cursor;

public class Exercise1_PersonalDetails2
{

   public static void main(String[] args)
   {
   String name, surname, telnum, yearOfBirth, height;
   List<String> catStrings = new ArrayList<>();
   
   name        = JOptionPane.showInputDialog("First name?");
   surname     = JOptionPane.showInputDialog("Surname?");
   telnum      = JOptionPane.showInputDialog("Cell number?");
   yearOfBirth = JOptionPane.showInputDialog("Year of birth YYYY?");
   height      = JOptionPane.showInputDialog("Height in metres? (with 1 dec. pl.)");
   
   catStrings.add(name);
   catStrings.add(surname);
   catStrings.add(telnum);
   catStrings.add(yearOfBirth);
   catStrings.add(height);
   String appended = "";
   // // 
// //    catStrings.forEach(t -> {String appended = ""; appended += t; });
// //    JOptionPane.showMessageDialog(null, appended); 
// not what they were looking for
for(String s : catStrings)
{
appended += "\n" + s;
}

// needs the string in the argument otherwise it's not happy
JOptionPane.showMessageDialog(null, appended, "LOOK AT THIS INFORMATION!!!", JOptionPane.INFORMATION_MESSAGE); 
  

   
    
 //   for (String s : catStrings)
//    {
//    appended.
//    }
   
   } // main method

} // Exercise1_PersonalDetails2 class
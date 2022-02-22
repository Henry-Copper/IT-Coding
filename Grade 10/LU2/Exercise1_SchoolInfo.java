// H Klopper 22 February 2022 LU2_Exercise1

import javax.swing.*;

public class Exercise1_SchoolInfo
{

   public static void main (String[] args)
   {
   
   String fullName = JOptionPane.showInputDialog("Please enter your full name");
   String schoolName = JOptionPane.showInputDialog("Please enter the name of your school");
   String gradeClass = JOptionPane.showInputDialog("Please enter your grade and class (e.g. 10MKI)");
   
   String header = "SCHOOL DETAILS\n--------------";
                        
   
  System.out.println(header);
  System.out.println("NAME: " + fullName);
  System.out.println("SCHOOL: " + schoolName);
  System.out.println("GRADE: " + gradeClass);
  
  
   } // main method

} // Exercise1_SchoolInfo class
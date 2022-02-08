// H Klopper 8 February 2022 LU2_Activity1

import java.io.*;

public class Activity1_MakeLabels
{

   public static void main (String[] args)
   {
   
   // intantiate string array of names and subjects
   String[] nameSubject = new String[]{"****************", "Tina Farinha", "Geography", "****************"};
   
   // try catch block to catch exceptions thrown by the FileWriter class upon instantiation or something like that that sounds correct
    try
   {
      
      // instantiate the filewriter object
      FileWriter fw = new FileWriter("filename.txt");

      // clear the previous file by writing nothing
      fw.write("");
     
      // iterate through the array and append each entry to the file
      for(int i = 0; i < nameSubject.length; i++)
      {
      fw.append(nameSubject[i]);   
      // escape code to create a new line for each entry
      fw.append("\n");
      }
      
      fw.close();
   
   }
   
   catch(IOException e)
   {
   // print message for exception thrown
   System.out.println(e.getMessage());
   }
   
   } // main method

} // saveText class
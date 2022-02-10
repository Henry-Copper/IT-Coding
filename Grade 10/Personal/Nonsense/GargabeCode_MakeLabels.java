// H Klopper 8 February 2022 LU2_Activity1

import java.io.*;
import java.util.Arrays;

public class GargabeCode_MakeLabels
{

   public static void main (String[] args)
   {
   
  // FileWriter writeToFile = new FileWriter("tthe");
   System.out.println("****************");
   System.out.println("Tina Farinha");
   System.out.println("Geography");
   System.out.println("****************");
   
   
   String[] strings = new String[]{"heheheh","hohohoh"};
   
   StringBuffer sb = new StringBuffer();
   for(int i = 0; i < strings.length; i++){
   sb.append(strings[i]);
   }
   String str = sb.toString();
 
   String str2 = Arrays.toString(strings);
   System.out.println(str2);
   
       try {
      FileWriter myWriter = new FileWriter("filename.txt");
      myWriter.write(str);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
   
   } // method main

} // class MakeLabels
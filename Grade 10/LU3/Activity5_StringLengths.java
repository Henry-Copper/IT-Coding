// H Klopper 13 May 2022 LU3_Activity5

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class Activity5_StringLengths
{

   public static void main (String[] args)
   {
   // initial step
   String[] strings = { "Jane", "Sam Nkomo", "Computers are great fun!" }; 
   
    for (String s : strings){
    System.out.println(buildString(s));
    }
    
    AnchorPane anchor = new AnchorPane();
    Scene scene = new Scene(anchor);
    Stage stage = new Stage();
    stage.setScene(scene);

// user input

   }
   
   private static String buildString(String str){
   
   return "\n\"" + str + "\" has " + str.length() + " characters in it ";
   
   }

}
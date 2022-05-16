// H Klopper 16 May 2022 LU3_Exercise2

import javax.swing.*;

public class Exercise2_ThreeWords {

    static String inputs;
    static String[] separateWords;

    public static void main (String[] args){
        inputs = JOptionPane.showInputDialog("Please enter three words separated by spaces");
        separateWords = inputs.split(" ");
        int totalChars = 0;

        for (String word : separateWords) {
            System.out.println('"' + word + "\" has " + word.length() + " character(s) in it.");
            totalChars += word.length();
        }

        System.out.println("In total you typed " + totalChars + " characters (not including whitespaces).");
    } // main method

} // Exercise2_ThreeWords class

// H Klopper 15 May 2022 LU3_Exercise2

import javax.swing.JOptionPane;
import java.util.jar.JarEntry;

import static javax.swing.JOptionPane.showInputDialog;

public class Exercise2_ThreeWords {

    static String inputs;
    static String[] separateWords;

    public static void main (String[] args){
        inputs = showInputDialog("Please enter three words separated by spaces");
        separateWords = inputs.split(" ");
        int totalChars = 0;

        for (String word : separateWords) {
            System.out.println('"' + word + "\" has " + word.length() + " character(s) in it.");
            totalChars += word.length();
        }

        double num = (32%7)*(26/8);
        System.out.println(32%7);
        System.out.println(26/8);
        System.out.println(num);

        System.out.println("In total you typed " + totalChars + " characters (not including whitespaces).");
    } // main method

} // Exercise2_ThreeWords class

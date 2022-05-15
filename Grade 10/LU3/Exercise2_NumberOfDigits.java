// H Klopper 15 May 2022

import javax.swing.*;

public class Exercise2_NumberOfDigits {

    static String digits;
    static int wholeNum;

    public static void main(String[] args) {

        digits = JOptionPane.showInputDialog("Please enter any integer");
        System.out.println(digits + " has " + digits.length() + " digits in it.");

        wholeNum = Integer.parseInt(digits);
        // fails because you cannot call a method on a primitive type; int is not an Object, and thus has no associated methods; int cannot be dereferenced, as it has no reference, it is simply a value in the stack
        // int length = wholeNum.length();

    } // main method

} // Exercise2_NumberOfDigits class

// H Klopper 4 June 2022 LU4_Activity3

import javax.swing.*;

public class Activity3_CalcPrice {

    public static void main(String[] args) {
        int price = Integer.parseInt(JOptionPane.showInputDialog("Enter the price: "));
        double discount = price * 0.05;
        double vat = (price - discount) * 0.15;
        System.out.println("The final amount is: " + (price - discount + vat));
    }

}

// H Klopper 8 June 2022 LU5_Activity2

import javax.swing.*;

public class Activity3_PrintStars {

    public static void main(String[] args) {

        try {
            int count = Integer.parseInt(JOptionPane.showInputDialog("Type in the symbol wanted."));
            String symbol = JOptionPane.showInputDialog("Type in the number of symbols wanted.");
            for (int i = 0; i < count; i++) {
                System.out.print(symbol);
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Not a number!");
        main(args);
        }



    } // main method

} // Activity3_PrintStars class

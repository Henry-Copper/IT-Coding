// H Klopper 14 February 2022 LU1_Checkpoint2

import it.*;

import java.awt.*;

public class Checkpoint2_Question18 {
    public static void main (String[] args){


        // 18.1
        Gogga jo = new Gogga();

        // 18.2
        jo.setPosition(14,0);

        // 18.3
        jo.setDirection(Gogga.DOWN);

        // 18.4
        jo.move();
        jo.move();
        jo.move();

        // 18.5
        jo.setDirection(Gogga.DOWN); // changes the direction instance field of the "jo" Gogga object to down by passing in an integer assigned to the constant "Gogga.DOWN"
        jo.setColor(Color.yellow);   // changes the colour instance field of the "jo" Gogga object to yellow by passing in a constant of "Color" type, which points to an object in memory with the RGB values: r: 255, g: 255, b: 0

        // 20
        // inverted commas / double quotes; string delimiter: one or more characters that separate text strings

        // 21
        // import it.*;

        // 22
        // The following would be a syntax error:
//        Gogga bug = new Gogga()
                // there is no semicolon at the end of the statement
        // corrected:
        Gogga bug = new Gogga();

        // 23
        // Name: Logical error
        // Example:
        int x = 1;
        for (int i = 0; i > 20; i ++){
            System.out.println(x);
            x++;
        }
        // this never runs, because i is not greater than 20 (condition i > 20 is always false)

    }
}

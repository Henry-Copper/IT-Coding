// H Klopper 14 February 2022 LU1_Checkpoint2_Question18

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

    }
}

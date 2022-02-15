// H Klopper 15 Februaryr 2022 LU1_Checkpoint2_Question16

import it.*;
import java.awt.*;

public class Checkpoint2_Question16_ColouredLines
{

    public static void main (String[] args)
    {
            Gogga louse = new Gogga();
            louse.setPosition(2,1 );
            louse.setDirection(Gogga.RIGHT);
            louse.setColor(Color.black);
            louse.move();

            louse.move();

            louse.setPosition(2, 3);
            louse.setDirection(Gogga.RIGHT);
            louse.setColor(Color.blue);
            louse.move();
            louse.move();

            louse.setPosition(2, 5);
            louse.setColor(Color.yellow);
            louse.move();
            louse.move();
    } // main method
} // Checkpoint2_Question16_ColouredLines class
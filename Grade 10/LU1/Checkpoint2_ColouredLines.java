// H Klopper 13 February 2022 LU1_Checkpoint2

import it.*;
import java.awt.*;

public class Checkpoint2_ColouredLines
{

        public static void main(String[] args)
        {
                Gogga louse = new Gogga();
                louse.setPosition(2, 1);
                louse.setDirection(Gogga.RIGHT);
                louse.setColor(Color.black);
                MoveGogga.moveGogga(louse, 10);

                louse.setPosition(2, 3);
                louse.setDirection(Gogga.RIGHT);
                louse.setColor(Color.blue);
                MoveGogga.moveGogga(louse, 10);

                // my bit
                louse.setPosition(2, 5);
                louse.setColor(Color.yellow);
                MoveGogga.moveGogga(louse, 10);

        } // main method

} // Checkpoint2_ColouredLines class

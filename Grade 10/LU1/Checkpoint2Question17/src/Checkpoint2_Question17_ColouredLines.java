// H Klopper 15 February 2022 LU1_Checkpoint2_Question17

import it.*;
import java.awt.*;

public class Checkpoint2_Question17_ColouredLines
{

        public static void main(String[] args)
        {
                Gogga louse = new Gogga();

                louse.setPosition(2, 1);
                louse.setDirection(Gogga.RIGHT);
                louse.setColor(Color.black);
                Checkpoint2_Question17_MoveGogga.move(louse, 10);

                louse.setPosition(2, 3);
                louse.setDirection(Gogga.RIGHT);
                louse.setColor(Color.blue);
                Checkpoint2_Question17_MoveGogga.move(louse, 10);

                // my bit
                louse.setPosition(2, 5);
                louse.setColor(Color.yellow);
                Checkpoint2_Question17_MoveGogga.move(louse, 10);

        } // main method

} // Checkpoint2_ColouredLines class

// H Klopper 3 February 2022 LU1_Exercise3

// added import statement

import it.*;

public class LetterS
{

   public static void main (String[] args)
   {
   
   // added brackets, changed name of Gogga object to "tick"
   
   Gogga tick = new Gogga();
   tick.setTrailWidth(12);
   tick.setPosition(8, 2);
   tick.setDirection(Gogga.LEFT);
   tick.move();
   tick.move();
   tick.move();
   tick.turnLeft();
   tick.move();
   tick.move();
   tick.move();
   tick.turnLeft();
   tick.move();
   tick.move();
   tick.move();
   tick.turnRight();
   tick.move();
   tick.move();
   tick.move();
   tick.turnRight();
   tick.move();
   tick.move();
   tick.move();

   } // main method

} // LetterS Class
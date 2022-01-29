// H Klopper 29 January 2022 LU1_Exercise1

import it.*;

public class Exercise1_Bumps
{

   static Gogga flea = new Gogga();

   public static void main(String[] args)
   {
   
      for(int i = 0; i < 2; i++)
      {
      rightmove();
      leftmove();
      }
   
   } // end of main method
   
   private static void rightmove()
   {
      flea.move();
      flea.turnRight();
      flea.move();
      flea.turnRight();
   } // end of rightmove method
   
   private static void leftmove()
   {
      flea.move();
      flea.turnLeft();
      flea.move();
      flea.turnLeft();
   } // end of leftmove method

} // end of Exercise1_Bumps class

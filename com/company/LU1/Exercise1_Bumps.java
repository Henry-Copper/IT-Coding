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
   
   }
   
   private static void rightmove()
   {
   flea.move();
   flea.turnRight();
   flea.move();
   flea.turnRight();
   }
   
   private static void leftmove()
   {
   flea.move();
   flea.turnLeft();
   flea.move();
   flea.turnLeft();
   }

}

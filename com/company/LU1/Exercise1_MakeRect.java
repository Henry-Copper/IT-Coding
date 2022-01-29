// H Klopper 29 January 2022 LU1_Exercise1

import it.*;

public class Exercise1_MakeRect
{

   static Gogga bug = new Gogga();

   public static void main(String[] args)
   {
   
      move(5);
      bug.turnLeft();
      move(2);
      bug.turnLeft();
      move(5);
      bug.turnLeft();
      move(2);
      bug.turnLeft();
   
   } // end of main method
   
   private static void move(int numberOfTimes)
   {
   
      for(int i = 0; i < numberOfTimes; i++)
      {
      bug.move();
      }
   
   } // end of move method
   
} // end of Exercise1_MakeRect class
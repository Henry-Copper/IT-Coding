// H Klopper 4 February 2022 LU1_Exercise4

// create algorithm for this

import it.*;

public class Exercise4_HeartBeat
{
   
   public static Gogga bug;
   
   private static int numSteps = 5;

   public static void main(String[] args)
   {
   
   
   Gogga.setGridSize(20,10);
   bug = new Gogga();  
   bug.setPosition(1,9);
   
   repeatedBit(bug);
   }
   
   public static void repeatedBit(Gogga critter)
   {
   
   System.out.println(numSteps);
   
   for(int i = 0; i < numSteps; i++)
   {
   critter.move();
   critter.turnRight();
   critter.move();
   critter.turnLeft();
   }
   
   critter.move();
   critter.turnRight();
   critter.move();
   critter.turnRight();
   
   numSteps++;
   for (int i = 0; i < numSteps; i++)
   {
   critter.move();
   }
   
   critter.turnLeft();
   critter.move();
   critter.move();
   critter.turnLeft();
   
   numSteps = numSteps - 3;
   if (numSteps > 0) repeatedBit(critter);
   
   }
   

}
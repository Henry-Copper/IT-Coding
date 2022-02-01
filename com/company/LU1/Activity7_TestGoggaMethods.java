// H Klopper 1 February 2022 LU1_Activity7

import it.*;
import java.awt.*;

public class Activity7_TestGoggaMethods
{

   static Gogga kreepy = new Gogga();

   public static void main(String[] args)
   {
   
   kreepy.setPosition(3,1);
   kreepy.setDirection(Gogga.RIGHT);
   kreepy.setLabel("kreepy");
   kreepy.setTrailWidth(9);
   kreepy.setColor(Color.blue);
   move(5);
   kreepy.trailOff();
   move(2);
   kreepy.trailOn();
   kreepy.move();

   }
   
   private static void move(int numberOfTimes)
   {
   
      for(int i = 0; i < numberOfTimes; i++)
      {
      kreepy.move();
      }
   
   }


}
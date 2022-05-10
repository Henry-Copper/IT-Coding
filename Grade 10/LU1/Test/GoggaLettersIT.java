package Test;

// Q 1.2
// H Klopper 17 February 2022 Consolidation Day Task: Question 1

// Q 1.3
import it.*;

// Q 1.4
import java.awt.*;

// Q 1.1
public class GoggaLettersIT
{

   // Q 1.5
   public static void main(String[] args)
   {
   
      // Q 1.6
      Gogga.setGridSize(15, 11);
      
      // Q 1.7: instantiate Gogga class, set the identifier as eye
      Gogga eye = new Gogga();
      
      // Q 1.8: instantiate Gogga class, set the identifier as tea
      Gogga tea = new Gogga();
      
      // Q 1.9: set position of eye Gogga instance
      eye.setPosition(6,8);
      
      // Q 1.10: set position of tea Gogga instance
      tea.setPosition(10,8);
      
      // Q 1.11: set eye's trail to blue
      eye.setColor(Color.blue);
      
      // Q 1.12: set tea's trail to yellow
      tea.setColor(Color.yellow);
      
      // Q 1.13: set trail width of both Gogga instances to 10
      eye.setTrailWidth(10);
      tea.setTrailWidth(10);
      
      // Q 1.14: Draw eye's I
      eye.turnLeft();
      move(eye, 4);
      eye.setPosition(4,8);
      eye.turnRight();
      move(eye, 6);
      eye.setPosition(2,2);
      eye.turnRight();
      move(eye, 4);
      
      // Q 1.14: Draw tea's T
      move(tea, 6);
      tea.setPosition(8,2);
      tea.turnRight();
      move(tea, 4);
      
   } // main method
   
   public static void move(Gogga bug, int numTimes)
   {
   
   for(int i = 0; i < numTimes; i++)
   {
   bug.move();
   }
   
   } // move method

} // GoggaLettersIT class
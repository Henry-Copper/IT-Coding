// H Klopper 8 June 2022 LU5_Activity2

import it.Gogga;

public class Activity2_MakeRectForLoop {

    public static void main(String[] args) {

        Gogga bug = new Gogga();

        for (int i = 0; i < 2; i++) {
            bug.move();
            bug.move();
            bug.turnLeft();
            bug.move();
            bug.turnLeft();
        }

    } // main method

} // Activity2_MakeRectForLoop class

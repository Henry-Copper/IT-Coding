// H Klopper 17 March 2022 LU2_Exercise5

public class Exercise5_Calculations
{

   public static void main (String[] args)
   {
    
//    1a
//    1.1) 32 / 3 = 10.666 = 10
//    1.2) 444 % 2: 444 / 2 = 222 (exactly); therefore 444 % 2 = 0
//    1.3) 43 / 12 - 16 / 7 = (3.58333) - (2.2857...) = 3 - 2 = 1
//    1.4) 1 + 15 / 4 = 1 + (3.75) = 1 + 3 = 4
//    1.5) 32 % 3: 32 / 3 = 10.666; therefore 32 % 3 = 32 - (10 * 3) = 32 - 30 = 2
//    1.6) 27 / 5 + 27 % 5 = (5.4) + (27 - 5 * 5) = 5 + (2) = 7
//    1.7) 65 / 9 + 38 % 6 - 76 % 8 = (7.222) + (38 - (38 / 6) * 6) - (76 - (76 / 8) * 8) = 7 + 2 - 4 = 9 - 4 = 5
//    1.8) 8 + 5 / 7 - 3 % 4 = 8 + (0) - (3) = 8 - 3 = 5    
//
//    1b
  System.out.println(32 / 3);
  System.out.println(444 % 2); 
  System.out.println(43 / 12 - 16 / 7);
  System.out.println(1 + 15 / 4);
  System.out.println(32 % 3);
  System.out.println(27 / 5 + 27 % 5);
  System.out.println(65 / 9 + 38 % 6 - 76 % 8);
  System.out.println(8 + 5 / 7 - 3 % 4);
  
  // 2
  System.out.println();
  // 2.1) 19 - 15 / 2 + 1 = 19 - 7 + 1 = 12 + 1 = 13 (integer)
  System.out.println(19 - 15 / 2 + 1);
  // 2.2) 8 - (27 / 6) * 2 = 8 - (4 * 2) = 8 - 8 = 0 (integer)
  System.out.println(8 - (27 / 6) * 2);
  // 2.3) 32 / 4 + 27 / 10 / 2 - 16 / 7 = 8 + (2 / 2) - 2 = 8 + 1 - 2 = 9 - 2 = 7 (integer)
  System.out.println(32 / 4 + 27 / 10 / 2 - 16 / 7);
  // 2.4) (7 + 2 * 5) / (64 - 6 * 10 + 2) + 35 / 5 * 2 + 15 % 11 = (7 + 10) / (64 - 60 + 2) + (7 * 2) + (4)  = 17 / 6 + 14 + 4 = 2 + 14 + 4 = 20 (integer)
  System.out.println((7 + 2 * 5) / (64 - 6 * 10 + 2) + 35 / 5 * 2 + 15 % 11);
  // 2.5) 7 * 3 + 7 % 3 = 21 + 1 = 22 (integer)
  System.out.println(7 * 3 + 7 % 3);
  // 2.6) 19 - (26 % 3) * 3 + 10.0 / 4 = 19 - 2 * 3 + 2.5 = 19 - 6 + 2.5 = 13 + 2.5 = 15.5 (real)
  System.out.println(19 - (26 % 3) * 3 + 10.0 / 4);   
  // 2.7) 64.2 + 5 % 7 = 64.2 + 5 = 69.2 (real)
  System.out.println(64.2 + 5 % 7);
  
   } // main method

} // Exercise5_Calculations class
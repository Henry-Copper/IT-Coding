// H Klopper 30 May 2022 LU3_Checkpoint2

public class Checkpoint2_EvaluateExpressions {

    public static void main(String[] args) {

        // Q1
        System.out.println(1.0 / (2.0 * 3.0)); // ✓✓✓
        System.out.println(Math.pow(2.0, 2.0 * 3.0 /* this is inline comment ! */ )); // ✓✓
        System.out.println((1.5 * Math.pow(10.0, -4.0)) + (2.5 * Math.pow(10.0, -2.0))); //
        System.out.println((3.0 + 4.0)/(5.0 + 6.0));

        // Q2
        double a = 2;
        double b = 3;
        double c = 5;
        int i = 2;
        int j = 3;
        System.out.println(a*b + c); // ✓ : 11.0: indicate data type
        System.out.println(a * (b+c));
        System.out.println(b / c * a);
        System.out.println(a / i / j);
        System.out.println(4 / b / 4);
        System.out.println(17 % (4 % 3.0));
        try {
            System.out.println(4 / (j / 4));
        }
        catch (ArithmeticException e){
            System.out.println("Integer division: 3 / 4 = 0.75 ≈ 0 therefore divided by 0.");
        }

        System.out.println(17 % (4 % b));

        // Q3
        /*
        public static int round(float a) || public static int round(double a)
Returns the closest int to the argument, with ties rounding to positive infinity.
Special cases:

If the argument is NaN, the result is 0.
If the argument is negative infinity or any value less than or equal to the value of Integer.MIN_VALUE, the result is equal to the value of Integer.MIN_VALUE.
If the argument is positive infinity or any value greater than or equal to the value of Integer.MAX_VALUE, the result is equal to the value of Integer.MAX_VALUE.
Parameters:
a - a floating-point (or double precision floating point) value to be rounded to an integer.
Returns:
the value of the argument rounded to the nearest int value.

         */
        /*
        public static double sqrt(double a)
        Returns the correctly rounded positive square root of a double value. Special cases:
        If the argument is NaN or less than zero, then the result is NaN.
        If the argument is positive infinity, then the result is positive infinity.
                If the argument is positive zero or negative zero, then the result is the same as the argument.
        Otherwise, the result is the double value closest to the true mathematical square root of the argument value.
                Parameters:
        a - a value.
                Returns:
        the positive square root of a. If the argument is NaN or less than zero, the result is NaN.
        */

        /*
        public static int   abs(int a)
        static double	    abs(double a)
        static float	    abs(float a)
        static int	        abs(int a)
        static long	        abs(long a)
Returns the absolute value of an int (or otherwise) value. If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned.
Note that if the argument is equal to the value of Integer.MIN_VALUE, the most negative representable int value, the result is that same value, which is negative.

Parameters:
a - the argument whose absolute value is to be determined
Returns:
the absolute value of the argument.

         */

        /*
        static double	pow(double a, double b)
        Returns the value of the first argument raised to the power of the second argument.
         */

        // Q4
        // The value of the first argument (the base) is raised to the power of the second (the exponent).

        // Q5
        System.out.println(Math.sqrt(-37.59));
        // Result is NaN, as the documentation states:         "If the argument is NaN or less than zero (negative), then the result is NaN." as you cannot find a non-imaginary square root of a negative number

        // Q6
        // these mostly output doubles with a .0 or another remainder as the Math class's methods returns doubles (sometimes)
        System.out.println(Math.pow(3.5, 2)); // = 3.5 ^ 2
        System.out.println(Math.abs(-5)); // finds the positive (absolute value)
        System.out.println(Math.round(-3.8)); // rounds to nearest integer value: -4
        System.out.println(Math.pow(65 % 9, 2)); // 65 % 9 = 2; 2 ^ 2 = 4
        System.out.println(Math.sqrt(150)); // square root of 150
        System.out.println(43 % 2 + 18 * Math.sqrt(36 / 4)); // = 1 + 18 * sqrt(9) = 1 + 18 * 3 = 1 + 54 = 55
        System.out.println(7 + 18 / 7.0 - 23 % 10); // = 7 + 2 (int division) - 3 = 6 (outputs an integer since all operands were integers)
        System.out.println(Math.sqrt(16)); // square root of 16 = 4
        System.out.println(Math.round(0.75)); // rounds to the nearest integer: 1
        System.out.println(Math.pow(Math.round(4.75), 2)); // = 5 ^ 2 = 25
        System.out.println(Math.round(Math.abs(14.75 - 20))); // absolute value of -5.25 = 5.25; 5.25 rounds to 5
        System.out.println(6 + 76 % 10 / 2.0); // = 6 + 6 / 2 = 6 + 3 = 9
        System.out.println(7.88 - Math.pow(12.5, 2)); // 7.88 - 12.5 ^ 2 = 7.88 - 156.25 = -148.37
        System.out.println(Math.round(14.7 - 0.95) + 2.5 * Math.abs(-6-4)); // 14.7 - 0.95 = 13.75 ≈ 14; -6 - 4 = -10 -> absolute = 10; 2.5 * 10 = 25; 14 + 25 = 39
        System.out.println(4 * Math.PI * Math.pow(5, 3)); // 5 ^ 3 = 125; 4 * 3.14159... * 125 = 1570,796327...

        // Q7
        // Math.PI refers to a final static field of the Math class, it doesn't do anything, it contains data (an approximate value of PI as a double)
        // It is declared with the keyword "final": it is a constant, it cannot be changed.

    } // main method


} // Checkpoint2_EvaluateExpressions class

// H Klopper 4 July 2022 FavouriteFruit exercise from class

import com.sun.source.tree.*;

import java.util.*;

public class FavouriteFruit {

    private static int numberOfFruits;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // collecting number of fruits to be inputted
        System.out.print("How many fruits you want? ");
        try {
            numberOfFruits = input.nextInt();
        }
        catch (Exception e){
            System.out.println("Not an integer!");
            main(args);
        }

        // initialise array of fruits and ratings with the number previously collected
        FruitAndRating[] fruitAndRatings = new FruitAndRating[numberOfFruits];

        // iteratively asking for each fruit's name and rating
        for (int i = 0; i < numberOfFruits; i++) {
            FruitAndRating fruit = new FruitAndRating();
            fruitAndRatings[i] = fruit;
            System.out.println("Please tell me about fruit number " + (i+1) + ':');
            System.out.print("Name: ");
            // consume the \n so that the name actually takes the input????
            input.nextLine();
            fruit.setFruitName(input.nextLine());
            System.out.print("Rating (out of 10): ");
            try {
                int currentRating = input.nextInt();
                // dividing by 0 in order to re-use the statements in the catch (janky, I know)
                if (currentRating <= 10) fruit.setRating(currentRating); else currentRating = 5 / 0;
            } catch (Exception e) {
                System.out.println("Not an integer between 0 and 10!");
                i--;
            }
        } // for loop

        // find the length of the longest name; used to determine the length of the buffer in printf
        int highestVal = 0;
        for(FruitAndRating currentFruit : fruitAndRatings){
            if (currentFruit.fruitName.length() > highestVal) highestVal = currentFruit.fruitName.length();
        }

        // print each fruit with its rating; use the longest fruit name as the right-aligned buffer length in printf
        double totalFruit = 0;
        for(FruitAndRating currentFruit : fruitAndRatings) {
            System.out.printf("%-" + (highestVal + 5) + "s%s\n", currentFruit.getFruitName(), currentFruit.getRating());
            totalFruit += currentFruit.rating;
        }
        System.out.println("Average rating: " + (totalFruit / numberOfFruits));

    }

//    public static Integer validIntegerInput(){
//        try {
//            int toTest = input.nextInt();
//            return toTest;
//        }
//        catch (Exception e){
//            System.out.println("Not an integer!");
//            return null;
//        }
//    }

    static class FruitAndRating{
        private String fruitName = "No name given";
        private int rating = 0;

        private void setFruitName(String fruitName){
            this.fruitName = fruitName;
        }

        private void setRating(int rating) throws Exception{
            this.rating = rating;
        }

        private String getFruitName() {
            return fruitName;
        }

        private int getRating() {
            return rating;
        }
    }

}

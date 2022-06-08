// H Klopper 19 May 2022 ConsolidationDay_Question2
// TODO: Add data validation using catch blocks
// TODO: add sin, cos, tan

import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Double.NaN;

public class Expressions {

    public static double evaluateNumericalExpression(String toEvaluate){
        ArrayList<String> listToEvaluate = parseAndSplit(toEvaluate);
//        doBracketsFirst(listToEvaluate);

//        for (String s : listToEvaluate) {
//            if (s.contains("((?<=/)|(?=/))")) {
//                System.out.println("shit");
//            }
//            ;
//        }
        return calculate(listToEvaluate);
    }

    private static ArrayList<String> parseAndSplit(String toSplit){

        // TODO: create a method that parses a string by any character, not just mathematical operators

        String[] splitExpression = toSplit.split(
                "((?<=/)|(?=/))" +
                        "|((?<=\\*)|(?=\\*))" +
                        "|((?<=\\+)|(?=\\+))" +
                        "|((?<=\\-)|(?=\\-))" +
                        "|((?<=\\()|(?=\\())" +
                        "|((?<=\\))|(?=\\)))"
                        );

        return new ArrayList<>(Arrays.asList(splitExpression));

    }

    private static double calculate(ArrayList<String> toCalculate){
        doBracketsFirst(toCalculate);
        // returns NaN if something goes wrong
        double result = NaN;

        // multiply and divide first
        for (int i = 0; i < toCalculate.size(); i++){
            try {
                double leftOperand = Double.parseDouble(toCalculate.get(i - 1));
                double rightOperand = Double.parseDouble(toCalculate.get(i + 1));
                switch(toCalculate.get(i)){
                    case "*":
                        result = leftOperand * rightOperand;
                        replaceOperandsAndOperators(toCalculate, i, result);

                        // set i = 0 because performing the operation and removing the left and right messes up the numbering
                        i = 0;
                        break;
                    case "/":
                        result = leftOperand / rightOperand;
                        replaceOperandsAndOperators(toCalculate, i, result);
                        i = 0;
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e){
                // not a Mathematical operator, thus will iterate once further into the ArrayList
            }
        }

        // add and subtract after multiply and divide
        for (int i = 0; i < toCalculate.size(); i++){
            try {
                double leftOperand = Double.parseDouble(toCalculate.get(i - 1));
                double rightOperand = Double.parseDouble(toCalculate.get(i + 1));
                switch(toCalculate.get(i)){
                    case "+":
                        result = leftOperand + rightOperand;
                        replaceOperandsAndOperators(toCalculate, i, result);
                        i = 0;
                        break;
                    case "-":
                        result = leftOperand - rightOperand;
                        replaceOperandsAndOperators(toCalculate, i, result);
                        i = 0;
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e){
                // not a Mathematical operator, thus will iterate once further into the ArrayList
            }
        }

        return result;
    }

    private static void doBracketsFirst(ArrayList<String> listWithBrackets){
        while(listWithBrackets.contains("(")) {
            int indexLeftBracket = listWithBrackets.indexOf("(");
            int indexRightBracket = listWithBrackets.indexOf(")");
            ArrayList<String> insideBrackets = new ArrayList<>(listWithBrackets.subList(indexLeftBracket + 1, indexRightBracket));
            listWithBrackets.subList(indexLeftBracket, indexRightBracket + 1).clear();
            listWithBrackets.add(indexLeftBracket, String.valueOf(calculate(insideBrackets)));
        }
    }

    private static void replaceOperandsAndOperators(ArrayList<String> toManipulate, int index, double result){
       // TODO find regex for this in order to use replaceALl()
        toManipulate.subList(index - 1, index + 2).clear();
        toManipulate.add(index - 1, String.valueOf(result));
    }

} // Expressions class
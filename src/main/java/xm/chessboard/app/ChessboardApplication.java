package xm.chessboard.app;

import xm.chessboard.helper.ChessboardHelper;
import xm.chessboard.helper.KnightNextStepCalculatorHelper;
import xm.chessboard.validator.ChessboardPositionValidator;
import xm.chessboard.validator.TimesToIterateValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ChessboardApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessboardPositionValidator chessboardPositionValidator = new ChessboardPositionValidator();
        TimesToIterateValidator timesToIterateValidator = new TimesToIterateValidator();
        ChessboardHelper chessboardHelper = new ChessboardHelper();
        KnightNextStepCalculatorHelper knightNextStepCalculatorHelper = new KnightNextStepCalculatorHelper(chessboardHelper);

        System.out.println("Please enter a starting point for your knight to begin(acceptable values: (A1..A8),(B1..B8)...(H1..H8): ");
        String startingPosition = scanner.next();

        while (!chessboardPositionValidator.isValid(startingPosition)) {
            System.out.println("Error: Please enter a starting point for your knight to begin(acceptable values: (A1..A8),(B1..B8)...(H1..H8): ");
            startingPosition = scanner.next();
        }

        System.out.println("Please enter an ending point for your knight to finish(acceptable values: (A1..A8),(B1..B8)...(H1..H8): ");
        String endingPosition = scanner.next();

        while (!chessboardPositionValidator.isValid(endingPosition)) {
            System.out.println("Error: Please enter an ending point for your knight to finish(acceptable values: (A1..A8),(B1..B8)...(H1..H8): ");
            endingPosition = scanner.next();
        }

        //Add handling for InputMismatchException thrown
        System.out.println("Please enter the total amount of times to iterate and run the process: ");
        int timesToIterate = scanner.nextInt();

        while (!timesToIterateValidator.isValid(timesToIterate)) {
            System.out.println("Error: Please enter the total amount of times to iterate and run the process(acceptable values: 1..10): ");
            timesToIterate = scanner.nextInt();
        }

        printPositions(startingPosition, endingPosition, knightNextStepCalculatorHelper);
    }

    private static void printPositions(String startingPoint, String endingPosition, KnightNextStepCalculatorHelper helper) {
        List<String> finalPathList = new ArrayList<>();
        for (String chessboardPosition : helper.calculateNextStepPositionsOfKnight(startingPoint)) {
            if (chessboardPosition.equals(endingPosition)) {
                finalPathList.add(startingPoint + " -> " + chessboardPosition);
            }

            for (String chessboardPosition2 : helper.calculateNextStepPositionsOfKnight(chessboardPosition)) {
                if (chessboardPosition2.equals(endingPosition)) {
                    finalPathList.add(startingPoint + " -> " + chessboardPosition + " -> " + chessboardPosition2);
                }

                for (String chessboardPosition3 : helper.calculateNextStepPositionsOfKnight(chessboardPosition2)) {
                    if (chessboardPosition3.equals(endingPosition)) {
                        finalPathList.add(startingPoint + " -> " + chessboardPosition + " -> " + chessboardPosition2 + " -> " + chessboardPosition3);
                    }
                }
            }
        }

        finalPathList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }
}

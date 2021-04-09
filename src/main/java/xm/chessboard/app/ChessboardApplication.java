package xm.chessboard.app;

import xm.chessboard.helper.KnightNextStepCalculatorHelper;
import xm.chessboard.service.KnightService;
import xm.chessboard.validator.ChessboardPositionValidator;

import java.util.*;

public class ChessboardApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessboardPositionValidator chessboardPositionValidator = new ChessboardPositionValidator();
        KnightNextStepCalculatorHelper knightNextStepCalculatorHelper = new KnightNextStepCalculatorHelper();
        KnightService chessboardKnightService = new KnightService(knightNextStepCalculatorHelper);

        System.out.print("Please enter a starting position for your knight to begin(acceptable values: (A1..A8),(B1..B8)...(H1..H8): ");
        String startingPosition = scanner.next();

        while (!chessboardPositionValidator.isValid(startingPosition)) {
            System.out.print("Error: Please enter a starting position for your knight to begin(acceptable values: (A1..A8),(B1..B8)...(H1..H8): ");
            startingPosition = scanner.next();
        }

        System.out.print("Please enter an ending position for your knight to finish(acceptable values: (A1..A8),(B1..B8)...(H1..H8): ");
        String endingPosition = scanner.next();

        while (!chessboardPositionValidator.isValid(endingPosition)) {
            System.out.print("Error: Please enter an ending position for your knight to finish(acceptable values: (A1..A8),(B1..B8)...(H1..H8): ");
            endingPosition = scanner.next();
        }

        //If starting position is the same as the ending position we assume that the quest for finding the path is over and we return the one node path
        if (startingPosition.equals(endingPosition)) {
            System.out.println("Solution Path: " + startingPosition);
            return;
        }

        Set<String> paths = chessboardKnightService.calculateSolutionPaths(startingPosition, endingPosition);

        if (paths.size() == 0) {
            System.out.println("No solution found!");
        } else {
            System.out.println("Solution Paths: ");
            paths.stream()
                    .sorted(Comparator.comparingInt(String::length))
                    .forEach(System.out::println);
        }
    }
}

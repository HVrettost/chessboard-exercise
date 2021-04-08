package xm.chessboard.app;

import xm.chessboard.helper.ChessboardHelper;
import xm.chessboard.helper.KnightNextStepCalculatorHelper;
import xm.chessboard.service.KnightService;
import xm.chessboard.validator.ChessboardPositionValidator;

import java.util.*;

public class ChessboardApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessboardPositionValidator chessboardPositionValidator = new ChessboardPositionValidator();
        ChessboardHelper chessboardHelper = new ChessboardHelper();
        KnightNextStepCalculatorHelper knightNextStepCalculatorHelper = new KnightNextStepCalculatorHelper(chessboardHelper);
        KnightService chessboardKnightService = new KnightService(knightNextStepCalculatorHelper);

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

        Set<String> paths = chessboardKnightService.calculateSolutionPaths(startingPosition, endingPosition);

        if (paths.size() == 0) {
            System.out.println("No solution has been found!");
        } else {
            paths.stream()
                    .sorted(Comparator.comparingInt(String::length))
                    .forEach(System.out::println);
        }
    }
}

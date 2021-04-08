package xm.chessboard.service;

import xm.chessboard.helper.KnightNextStepCalculatorHelper;

import java.util.HashSet;
import java.util.Set;

public class KnightService {

    private final KnightNextStepCalculatorHelper knightNextStepCalculatorHelper;

    public KnightService(KnightNextStepCalculatorHelper knightNextStepCalculatorHelper) {
        this.knightNextStepCalculatorHelper = knightNextStepCalculatorHelper;
    }

    public Set<String> calculateSolutionPaths(String startingPoint, String endingPosition) {
        Set<String> paths = new HashSet<>();
        for (String chessboardPosition : knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(startingPoint)) {
            if (chessboardPosition.equals(endingPosition)) {
                paths.add(startingPoint + " -> " + chessboardPosition);
            }

            for (String chessboardPosition2 : knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(chessboardPosition)) {
                if (chessboardPosition2.equals(endingPosition)) {
                    paths.add(startingPoint + " -> " + chessboardPosition + " -> " + chessboardPosition2);
                }

                for (String chessboardPosition3 : knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(chessboardPosition2)) {
                    if (chessboardPosition3.equals(endingPosition)) {
                        paths.add(startingPoint + " -> " + chessboardPosition + " -> " + chessboardPosition2 + " -> " + chessboardPosition3);
                    }
                }
            }
        }

        return paths;
    }
}

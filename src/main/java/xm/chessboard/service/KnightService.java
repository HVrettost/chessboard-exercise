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
        final Set<String> paths = new HashSet<>();

        knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(startingPoint).forEach(chessboardPosition -> {
            if (chessboardPosition.equals(endingPosition)) {
                paths.add(startingPoint + " -> " + chessboardPosition);
            }

            knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(chessboardPosition).forEach(chessboardPosition2 -> {
                if (chessboardPosition2.equals(endingPosition)) {
                    paths.add(startingPoint + " -> " + chessboardPosition + " -> " + chessboardPosition2);
                }

                knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(chessboardPosition2).forEach(chessboardPosition3 -> {
                    if (chessboardPosition3.equals(endingPosition)) {
                        paths.add(startingPoint + " -> " + chessboardPosition + " -> " + chessboardPosition2 + " -> " + chessboardPosition3);
                    }
                });
            });
        });

        return paths;
    }
}

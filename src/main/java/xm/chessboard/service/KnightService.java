package xm.chessboard.service;

import xm.chessboard.exception.BreakOutOfLoopException;
import xm.chessboard.helper.KnightNextStepCalculatorHelper;

import java.util.HashSet;
import java.util.Set;

public class KnightService {

    private final KnightNextStepCalculatorHelper knightNextStepCalculatorHelper;

    public KnightService(KnightNextStepCalculatorHelper knightNextStepCalculatorHelper) {
        this.knightNextStepCalculatorHelper = knightNextStepCalculatorHelper;
    }

    public Set<String> calculateSolutionPaths(String startingPosition, String endingPosition) {
        final Set<String> paths = new HashSet<>();

        try {
            knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(startingPosition).forEach(chessboardPosition -> {
                if (chessboardPosition.equals(endingPosition)) {
                    paths.add(startingPosition + " -> " + chessboardPosition);
                    throw new BreakOutOfLoopException();
                }

                knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(chessboardPosition).forEach(chessboardPosition2 -> {
                    if (chessboardPosition2.equals(endingPosition)) {
                        paths.add(startingPosition + " -> " + chessboardPosition + " -> " + chessboardPosition2);
                    }

                    knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(chessboardPosition2).forEach(chessboardPosition3 -> {
                        if (chessboardPosition3.equals(endingPosition)) {
                            paths.add(startingPosition + " -> " + chessboardPosition + " -> " + chessboardPosition2 + " -> " + chessboardPosition3);
                        }
                    });
                });
            });
        } catch (BreakOutOfLoopException ignored) {}

        return paths;
    }
}

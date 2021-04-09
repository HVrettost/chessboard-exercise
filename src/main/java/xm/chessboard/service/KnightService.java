package xm.chessboard.service;

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

        knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(startingPosition).forEach(chessboardPosition -> {
            if (chessboardPosition.equals(endingPosition)) {
                paths.add(startingPosition + " -> " + chessboardPosition);
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

        return paths;
    }

    public Set<String> calculateSolutionPathsWithIterationInput(String startingPosition, String endingPosition) {
        final Set<String> paths = new HashSet<>();
        recursiveMethod(startingPosition, endingPosition, paths, startingPosition, 1);
        return paths;
    }

    private void recursiveMethod(String startingPosition, String endingPosition, Set<String> paths, String tempPath, int counter) {
        if (counter == 3) {
            for (String chessboardPosition : knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(startingPosition)) {
                tempPath += " -> " + chessboardPosition;
                if (chessboardPosition.equals(endingPosition)) {
                    paths.add(tempPath + " -> " + chessboardPosition);
                }
            }
            tempPath = "";
            counter --;
        } else {
            for (String chessboardPosition : knightNextStepCalculatorHelper.calculateNextStepPositionsOfKnight(startingPosition)) {
                tempPath += " -> " + chessboardPosition;
                if (chessboardPosition.equals(endingPosition)) {
                    paths.add(startingPosition + " -> " + chessboardPosition);
                }
                counter++;
                recursiveMethod(chessboardPosition, endingPosition, paths, tempPath, counter);
            }
        }

    }
}

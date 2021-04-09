package xm.chessboard.helper;

import xm.chessboard.model.CartesianPair;

import java.util.HashSet;
import java.util.Set;

public class KnightNextStepCalculatorHelper extends ChessboardHelper {

    public Set<String> calculateNextStepPositionsOfKnight(String position) {
        Set<String> nextSteps = new HashSet<>();
        CartesianPair cartesianPair = findCartesianPairFromPosition(position)
                .orElseThrow(() -> new IllegalArgumentException("Chessboard position is not valid"));
        findPositionFromCartesianPair(findIPlusOneJMinusTwo(cartesianPair)).ifPresent(nextSteps::add);
        findPositionFromCartesianPair(findIPlusTwoJPlusOne(cartesianPair)).ifPresent(nextSteps::add);
        findPositionFromCartesianPair(findIMinusTwoJPlusOne(cartesianPair)).ifPresent(nextSteps::add);
        findPositionFromCartesianPair(findIMinusTwoJMinusOne(cartesianPair)).ifPresent(nextSteps::add);
        findPositionFromCartesianPair(findIPlusOneJPlusTwo(cartesianPair)).ifPresent(nextSteps::add);
        findPositionFromCartesianPair(findIMinusOneJPlusTwo(cartesianPair)).ifPresent(nextSteps::add);
        findPositionFromCartesianPair(findIMinusOneJMinusTwo(cartesianPair)).ifPresent(nextSteps::add);
        findPositionFromCartesianPair(findIPlusTwoJMinusOne(cartesianPair)).ifPresent(nextSteps::add);

        return nextSteps;
    }

    private CartesianPair findIPlusOneJMinusTwo(CartesianPair cartesianPair) {
        return new CartesianPair(cartesianPair.getI() + 1, cartesianPair.getJ() - 2);
    }

    private CartesianPair findIPlusTwoJPlusOne(CartesianPair cartesianPair) {
        return new CartesianPair(cartesianPair.getI() + 2, cartesianPair.getJ() + 1);
    }

    private CartesianPair findIMinusTwoJPlusOne(CartesianPair cartesianPair) {
        return new CartesianPair(cartesianPair.getI() - 2, cartesianPair.getJ() + 1);
    }

    private CartesianPair findIMinusTwoJMinusOne(CartesianPair cartesianPair) {
        return new CartesianPair(cartesianPair.getI() - 2, cartesianPair.getJ() - 1);
    }

    private CartesianPair findIPlusOneJPlusTwo(CartesianPair cartesianPair) {
        return new CartesianPair(cartesianPair.getI() + 1, cartesianPair.getJ() + 2);
    }

    private CartesianPair findIMinusOneJPlusTwo(CartesianPair cartesianPair) {
        return new CartesianPair(cartesianPair.getI() - 1, cartesianPair.getJ() + 2);
    }

    private CartesianPair findIMinusOneJMinusTwo(CartesianPair cartesianPair) {
        return new CartesianPair(cartesianPair.getI() - 1, cartesianPair.getJ() - 2);
    }

    private CartesianPair findIPlusTwoJMinusOne(CartesianPair cartesianPair) {
        return new CartesianPair(cartesianPair.getI() + 2, cartesianPair.getJ() - 1);
    }
}

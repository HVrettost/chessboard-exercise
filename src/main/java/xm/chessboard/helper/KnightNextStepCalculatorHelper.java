package xm.chessboard.helper;

import xm.chessboard.model.CartesianPair;

import java.util.HashSet;
import java.util.Set;

public class KnightNextStepCalculatorHelper {

    private final ChessboardHelper chessboardHelper;

    public KnightNextStepCalculatorHelper(ChessboardHelper chessboardHelper) {
        this.chessboardHelper = chessboardHelper;
    }

    public Set<String> calculateNextStepPositionsOfKnight(String position) {
        Set<String> nextSteps = new HashSet<>();
        CartesianPair cartesianPair = chessboardHelper.findCartesianPairFromPosition(position).orElseThrow();
        chessboardHelper.findPositionFromCartesianPair(findIPlusOneJMinusTwo(cartesianPair)).ifPresent(nextSteps::add);
        chessboardHelper.findPositionFromCartesianPair(findIPlusTwoJPlusOne(cartesianPair)).ifPresent(nextSteps::add);
        chessboardHelper.findPositionFromCartesianPair(findIMinusTwoJPlusOne(cartesianPair)).ifPresent(nextSteps::add);
        chessboardHelper.findPositionFromCartesianPair(findIMinusTwoJMinusOne(cartesianPair)).ifPresent(nextSteps::add);
        chessboardHelper.findPositionFromCartesianPair(findIPlusOneJPlusTwo(cartesianPair)).ifPresent(nextSteps::add);
        chessboardHelper.findPositionFromCartesianPair(findIMinusOneJPlusTwo(cartesianPair)).ifPresent(nextSteps::add);
        chessboardHelper.findPositionFromCartesianPair(findIMinusOneJMinusTwo(cartesianPair)).ifPresent(nextSteps::add);
        chessboardHelper.findPositionFromCartesianPair(findIPlusTwoJMinusOne(cartesianPair)).ifPresent(nextSteps::add);

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

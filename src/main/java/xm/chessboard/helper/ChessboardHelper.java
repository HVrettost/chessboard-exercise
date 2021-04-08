package xm.chessboard.helper;

import xm.chessboard.enumeration.Chessboard;
import xm.chessboard.model.CartesianPair;

import java.util.EnumSet;
import java.util.Optional;

public class ChessboardHelper {

    protected Optional<CartesianPair> findCartesianPairFromPosition(String position) {
        return EnumSet.allOf(Chessboard.class)
                .stream()
                .filter(chessboardPosition -> chessboardPosition.getPosition().equals(position))
                .findAny()
                .map(Chessboard::getCartesianPair);
    }

    protected Optional<String> findPositionFromCartesianPair(CartesianPair cartesianPair) {
        return EnumSet.allOf(Chessboard.class)
                .stream()
                .filter(chessboardPosition -> chessboardPosition.getCartesianPair().getI() == cartesianPair.getI() &&
                        chessboardPosition.getCartesianPair().getJ() == cartesianPair.getJ())
                .findFirst()
                .map(Chessboard::getPosition);
    }
}

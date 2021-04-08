package xm.chessboard.validator;

import xm.chessboard.enumeration.Chessboard;

import java.util.EnumSet;

public class ChessboardPositionValidator implements Validator<String> {

    @Override
    public boolean isValid(String position) {
        return EnumSet.allOf(Chessboard.class)
                .stream()
                .map(Chessboard::getPosition)
                .anyMatch(p -> p.equals(position));
    }
}
